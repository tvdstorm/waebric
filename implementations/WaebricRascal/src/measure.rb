require 'find';

class MetricCalculation
	def initialize(dir)
		$dir = dir
		val_in = AverageMetric.new("VAL_IN").calculate
		val_out = AverageMetric.new("VAL_OUT").calculate
		
		puts "val-in: " + val_in.to_s
		puts "val-out: " + val_out.to_s
	end
end

class AverageMetric
	def initialize(metric_name)
		@metric_name = metric_name
	end
	
	def calculate
		num_val_in = 0
		tot_val_in = 0
		
		Find.find($dir) do |file_loc|
			if File.extname(file_loc) == '.rsc' then
				file = File.open(file_loc)
				while (line = file.gets) != nil do
					if /.*#{@metric_name}: \d+.*/ =~ line then
						num_val_in += 1
						line = line.delete "#{@metric_name}: "
						tot_val_in += Float(line)
					end
				end
			end
		end
		
		if tot_val_in > 0 then
			return tot_val_in / num_val_in
		else 
			return 0
		end
	end
end

MetricCalculation.new('..')
