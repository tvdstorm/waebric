require 'find'
require 'ftools'

class MetricCalculation
	def initialize(transf_languages)
		@fan_in = {}
		@fan_out = {}
		@functions = {}
		@signatures = {}
		@val_in = {}
		@val_out = {}
		@inf_fl_comp = {}
		transf_languages.each do |info, filetype, dir, printDependencies|
			$filetype = filetype
			$dir = dir
			$doPrint = printDependencies
		
			@fan_in[info], @fan_out[info], @functions[info], @signatures[info], @val_in[info], @val_out[info] = CalculateMetrics.new("FUNCTION").calculate
			@inf_fl_comp[info] = informationFlowComplexity(@fan_in[info], @fan_out[info])
			puts info + " metrics: "
			puts ""
			puts "functions: " + @functions[info].to_s
			puts "signatures: " + @signatures[info].to_s
			puts "signatures/function: " + (Float(@signatures[info])/Float(@functions[info])).to_s
			puts "val-in: " + (sum(@val_in[info])/@functions[info]).to_s

			puts "val-out: " + (sum(@val_out[info])/@functions[info]).to_s
		
			puts "fan-in/function: " + (sum(@fan_in[info])/@functions[info]).to_s
		
			puts "fan-out/function: " + (sum(@fan_out[info])/@functions[info]).to_s
		
			puts "information flow complexity (function)/function: " + (sum(@inf_fl_comp[info])/@functions[info]).to_s

			puts "======"
		end
		
		
		createRFiles("val in", @val_in)
		createRFiles("val out", @val_out)
		createRFiles("fan in", @fan_in)
		createRFiles("fan out", @fan_out)
		createRFiles("information flow complexity", @inf_fl_comp)
		
		
	end
	
	def createRFiles(metric, valueList)
		sampleSize = 100
		data = ""
		dataName = ""	
		valueList.each do |key, values|
			data += "approx(c(" + printFunctionMetric(values) + "), n=#{sampleSize}), "
			dataName += "\"#{key}\", "
		end
		data = data[0, data.size-2]
		dataName = dataName[0, dataName.size-2]
			
		filename = "R_Generated_Graphs/#{metric.gsub(" ", "_")}"
		content = "
		pdf(\"R_Generated_Graphs/#{metric}.pdf\")
		numOfLines <- #{valueList.size}
		
		dataset <- data.frame(
			#{data}
		)

		rangeMaxY <- -1		
		for(i in 1:numOfLines*2){
			currRange <- range(dataset[i])
			if(i%%#{valueList.size}==0){
				if(max(currRange) > rangeMaxY){
					rangeMaxY <- max(currRange)
				}
			}
		}
		rangeY = c(0, rangeMaxY)

		rangeX <- c(0, 100)
		plot(rangeX, rangeY,
			main=\"Comparison of \\\"#{metric}\\\" values\", 
			type=\"n\", 
			xlab=\"Percentage of functions with at most the corresponding \\\"#{metric}\\\"\", 
			ylab=\"#{metric}\"
		)
		
		ltys <- c(1:(numOfLines))
 		for (i in 1:numOfLines){
 			lines(dataset[i*numOfLines],  type=\"l\", lwd=1.5, lty=ltys[i], pch=i)
 		}
 		
		names <- c(
			#{dataName}
		)
		
 		legend(rangeX[1], rangeY[2],
 			names, 
 			cex=1.1, 
 			lty=ltys,
 			title=\"Transformation language\"
 		)

		dev.off()		
		
		"
		filenameR = filename + ".R"
		file = File.new(filenameR, 'w')
		file.write content
		file.close
		%x[R CMD BATCH #{filenameR} --no-save]
		File.delete(filenameR)
		File.delete('--no-save')
	end
		
	def informationFlowComplexity(fan_in, fan_out)
		toReturn = {}
		(fan_in.keys & fan_out.keys).each do |key|
			toReturn[key] = (fan_in[key]*fan_out[key])*(fan_in[key]*fan_out[key])
		end
		return toReturn
	end
	
	def printFunctionMetric(arr)
		lijst = Array.new
		
		arr.each do |k,v|
			lijst += [Float(v)]
		end
		lijst = lijst.sort
		toReturn = ""

		lijst.each do |i|
			toReturn += "#{i}, "
		end
		toReturn = toReturn[0, toReturn.size-2]		

		return toReturn
	end
	
	def sum(arr)
		tot = Float(0)
		arr.each do |k,v|
			tot += Float(v)
		end
		return tot
	end
end

class CalculateMetrics
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		callGraph = Array.new
		@fun_val = {}
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == $filetype then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /\w*#{@metric_name} \((\d+)->(\d+)\): ([\w\-]+).*/ =~ line then
						if @fun_val.has_key? $3 then
							@fun_val[$3][0] += Float($1)
							@fun_val[$3][1] += Float($2)
							@fun_val[$3][2] += 1
						else	
							@fun_val[$3] = Float($1), Float($2), 1
						end
					end
				
					if /\w*#{@metric_name} \((\d+)->(\d+)\): ([\w\-]+) *-> *([\w,\- ]+)( )*/ =~ line then		
							
						func = $3
						calls = $4.split(/, */)
						item = Array.new
						calls.each do |x|
							item += ["#{x.strip}"]
						end
						call = ["#{func.strip}", item]
						callGraph += call
					end
				end
			end
		end

		@fanOut = {}
		for t in 0...callGraph.size do
			if t%2 == 0 then
				item = callGraph[t]
				if @fanOut[item]==nil then
					@fanOut[item] = Array.new
				end
				Array value = callGraph[t+1]
				@fanOut[item] += [value]
				@fanOut[item] = @fanOut[item].flatten.uniq
			end
		end
		
		@fanIn = {}
		for t in 0...callGraph.size do
			if t%2 == 1 then 
				callGraph[t].each do |item|
					if not @fanIn.has_key? item then
						@fanIn[item] = Array.new
					end
					Array value = callGraph[t-1]
					@fanIn[item] += [value]
					@fanIn[item] = @fanIn[item].flatten.uniq
				end
			end 			
		end
		@fanIn = @fanIn.delete_if{ |k,v|
			@fanOut.keys.include?(k)==false
		}
		
		@num_of_signatures = 0
		@val_in = {}
		@val_out = {}
		@fun_val.keys.each do |key|
			@num_of_signatures += @fun_val[key][2]
			@val_in[key] = @fun_val[key][0]/@fun_val[key][2]
			@val_out[key] = @fun_val[key][1]/@fun_val[key][2]
		end
		@num_of_functions = @fun_val.size
		
		if $doPrint then printDependencies end
		
		return listOf_fan_in, listOf_fan_out, @num_of_functions, @num_of_signatures, @val_in, @val_out
	end
	
	def listOf_fan_in
		toReturn = {}
		keys = @fanIn.keys
		keys.each do |key|
			toReturn[key] = Float(@fanIn[key].size)
		end
		return toReturn
	end
	
	def listOf_fan_out
		toReturn = {}
		keys = @fanOut.keys
		keys.each do |key|
			toReturn[key] = Float(@fanOut[key].size)
		end
		return toReturn
	end
	
	def printMe(table)
		table.keys.each do |x|
			val = "[#{x}] "
			for i in table[x] do 
				if i != nil then
					val += i.to_s+", " 
				end
			end
			puts val.sub(/, $/, "") 
		end
	end
	
	def printDependencies
		puts "Fan-in:"
		puts ""
		printMe(@fanIn)
		puts "===================="
		puts "Fan-out:"
		puts ""
		printMe(@fanOut)
		puts "===================="
	end
end

MetricCalculation.new([
	['Rascal', '.rsc', '..', false], 
	['ASF+SDF', '.asf', './compiler(asf+sdf)/', false]
])
