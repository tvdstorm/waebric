require 'find';

class MetricCalculation
	def initialize(info, filetype, dir)
		$filetype = filetype
		$dir = dir
		val_in = CountMetric.new("VAL_IN").calculate
		val_out = CountMetric.new("VAL_OUT").calculate
		fan_in, fan_out, functions, signatures = CalculateMetrics.new("FUNCTION").calculate

		puts info
		puts ""
		puts "functions: " + functions.to_s
		puts "signatures: " + signatures.to_s
		puts "signatures/function: " + (Float(signatures)/Float(functions)).to_s
		puts "val-in: " + (val_in/functions).to_s
		puts "val-out: " + (val_out/functions).to_s
		puts "fan-in/function: " + (fan_in/functions).to_s
		puts "fan-out/function: " + (fan_out/functions).to_s
		puts "======"
		
	end
end

class CalculateMetrics
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		callGraph = Array.new
		@functions = []
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == $filetype then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /\w*#{@metric_name}: ?([\w\-]+).*/ =~ line then
						@functions += [$1]
					end
				
					if /\w*#{@metric_name}: ?([\w\-]+) *-> *([\w,\- ]+)( )*/ =~ line then		
							
						func = $1
						calls = $2.split(/, */)
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
		@num_of_signatures = @functions.size
		@num_of_functions = @functions.uniq.size

		#printDependencies
		
		return average_fan_in, average_fan_out, @num_of_functions, @num_of_signatures
	end
	
	def average_fan_in
		tot = 0.0
		keys = @fanIn.keys
		keys.each do |key|
			tot += @fanIn[key].size
		end
		return tot
	end
	
	def average_fan_out
		tot = 0.0
		keys = @fanOut.keys
		keys.each do |key|
			tot += @fanOut[key].size
		end
		return tot
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


class CountMetric
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		tot = 0
		num = 0
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == $filetype then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /.*#{@metric_name}:[ ]*(\d+?)[. \-]*/ =~ line then
						num += 1
						tot += Float($1)
					end
				end
			end
		end
		
		if tot > 0 then
			puts "?? " + num.to_s
			return tot
		else 
			return 0
		end
	end
end
MetricCalculation.new('Rascal metrics: ', '.rsc', '..')
MetricCalculation.new('ASF+SDF metrics:', '.asf', './compiler(asf+sdf)/')
