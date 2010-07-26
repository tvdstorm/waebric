require 'find';

class MetricCalculation
	def initialize(info, filetype, dir, printDependencies)
		$filetype = filetype
		$dir = dir
		$doPrint = printDependencies
		
		fan_in, fan_out, functions, signatures, val_in, val_out = CalculateMetrics.new("FUNCTION").calculate

		puts info
		puts ""
		puts "functions: " + functions.to_s
		puts "signatures: " + signatures.to_s
		puts "signatures/function: " + (Float(signatures)/Float(functions)).to_s
		puts "val-in: " + (sum(val_in)/functions).to_s
		puts "val-out: " + (sum(val_out)/functions).to_s
		puts "fan-in/function: " + (sum(fan_in)/functions).to_s
		puts "fan-out/function: " + (sum(fan_out)/functions).to_s

#		printFunctionMetric(fan_in)

		puts "======"
		
	end
	
	def printFunctionMetric(arr)
		arr.each do |k,v|
			puts "\[#{k}\] #{v}"
		end
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
			toReturn[@fanIn[key]] = @fanIn[key].size
		end
		return toReturn
	end
	
	def listOf_fan_out
		toReturn = {}
		keys = @fanOut.keys
		keys.each do |key|
			toReturn[@fanOut[key]] = @fanOut[key].size
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

#MetricCalculation.new('Test metrics: ', '.test', '.', false)
MetricCalculation.new('Rascal metrics: ', '.rsc', '..', false)
MetricCalculation.new('ASF+SDF metrics:', '.asf', './compiler(asf+sdf)/', false)
