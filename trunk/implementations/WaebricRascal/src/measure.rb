require 'find';

class MetricCalculation
	def initialize(dir)
		$dir = dir
		val_in = AverageMetric.new("VAL_IN").calculate
		val_out = AverageMetric.new("VAL_OUT").calculate
		fan_in, fan_out = CalculateFanMetrics.new("FUNCTION").calculate
		
		puts "val-in: " + val_in.to_s
		puts "val-out: " + val_out.to_s
		puts "avg fan-in: " + fan_in.to_s
		puts "avg fan-out: " + fan_out.to_s
		
	end
end

class CalculateFanMetrics
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		callGraph = []
		
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == '.rsc' then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /\w*#{@metric_name}: ?(\w+) *-> *([\w, ]+)( )*/ =~ line then
						func = $1
						calls = $2.split(/, */)
						item = []
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
				@fanOut[item] = callGraph[t+1].size
			end 			
		end
		
		@fanIn = {}
		for t in 0...callGraph.size do
			if t%2 == 1 then 
				callGraph[t].each do |item|
					if @fanIn.has_key? item then
						@fanIn[item] = 1 + Integer(@fanIn[item])
					else
						@fanIn[item] = 1
					end
				end
			end 			
		end
						
		return average_fan_in, average_fan_out
	end
	
	def average_fan_in
		tot = 0.0
		keys = @fanIn.keys
		keys.each do |key|
			tot += @fanIn[key]
		end
		puts "calls fan-in #{@fanIn.size}"
		@fanIn.keys.each do |x| puts x end
		return tot/keys.size
	end
	
	def average_fan_out
		tot = 0.0
		keys = @fanOut.keys
		keys.each do |key|
			tot += @fanOut[key]
		end
#		puts "calls fan-out #{@fanOut.size}"
#		@fanOut.keys.each do |x| puts x end

#		k = (@fanIn.keys & @fanOut.keys)
#		k.each do |x| 
#			puts x 
#		end

		return tot/keys.size
	end
end


class AverageMetric
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		num = 0
		tot = 0
		
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == '.rsc' then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /.*#{@metric_name}: (\d+?).*/ =~ line then
						num += 1
						tot += Float($1)
					end
				end
			end
		end
		
		if tot > 0 then
			return tot / num
		else 
			return 0
		end
	end
end

MetricCalculation.new('..')
