#	This script was made to compare the java code generated with the rascal waebric compiler
#	to the java code generated with the ASF+SDF implementation. 

#	Two files aren't required to have identical indentation to be identical java files, so 
#	multiple indentation characters compare to a single indentation character. (This isn't
#	correct within java strings but the testset doesn't have such cases, and if it did it would
#	result in a mismatch and you could easily compare those files by hand.)

#	You may want to increase your stacksize before running this script because ruby 
#	doesn't handle recursion very well. (ulimit -s 512000 worked for me). 
#	Ruby v1.8.6 was used.


require 'find'
require 'ftools'

class CompareMultipleFiles
	def initialize(firstMap, secondMap)
		Find.find(firstMap) do |firstFile|
			if !File.directory? firstFile then
				fileName = File.basename(firstFile)
				secondFileName = "#{secondMap}#{fileName}"
				if File.exists? secondFileName then
					secondFile = File.new(secondFileName).path
					CompareFiles.new(File.new(firstFile).path, secondFile)
				else
					#puts "#{fileName} not found."
				end
			end
		end
	end
end


class CompareFiles

    def initialize(fileA, fileB)
        $max_chars_after_mismatch = 150
   
        @fileA = fileA
        @fileB = fileB
        @ignore = /[ \n\t]/
        @copy = CharGetter.new(fileA, @ignore, " ")
        @orig = CharGetter.new(fileB, @ignore, " ")

        p = compare(@copy.nextChar, @orig.nextChar)
		if p!="" then puts p end
    end
   
    def compare(c1, c2)
        # (STOP CONDITION) Files are equal to eachother.
        if c1==nil and c2==nil then
            return "#{File.basename(@fileA)} contains no mismatches!"

        # (STOP CONDITION) First file is shorther than the second.   
        elsif c1==nil then
            msg = c2
            y1, x1, y2, x2 = @copy.getLine, @copy.getIndex, @orig.getLine, @orig.getIndex
           
            chars_after_mismatch = 0
            while (char = @orig.nextChar)!=nil and chars_after_mismatch < $max_chars_after_mismatch do
                max_chars_after_mismatch += 1
                msg << char
            end
            if (msg =~ /\A#{@ignore}*\Z/)!=nil then
                return compare(nil, nil)
            else
                return getReturnMessage("EOF", y1, x1, msg, y2, x2)
            end
           
        # (STOP CONDTION) First file is longer than the second file.
        elsif c2==nil then
            msg = c1
            y1, x1, y2, x2 = @copy.getLine, @copy.getIndex, @orig.getLine, @orig.getIndex
            chars_after_mismatch = 0           
            while (char = @copy.nextChar)!=nil and chars_after_mismatch < $max_chars_after_mismatch do
                max_chars_after_mismatch += 1           
                msg << char
            end
            if (msg =~ /\A#{@ignore}*\Z/)!=nil then
                return compare(nil, nil)
            else
                return getReturnMessage(msg, y1, x1, "EOF", y2, x2)
            end


        # (STOP CONDTION) Character mismatch
        elsif c1!=c2 then
            mismatch_1, mismatch_2 = c1, c2
            y1, x1, y2, x2 = @copy.getLine, @copy.getIndex, @orig.getLine, @orig.getIndex
            chars_after_mismatch = 0
            while (char = @copy.nextChar)!=nil and chars_after_mismatch < $max_chars_after_mismatch do
                chars_after_mismatch += 1
                mismatch_1 << char
            end
            chars_after_mismatch = 0           
            while (char = @orig.nextChar)!=nil and chars_after_mismatch < $max_chars_after_mismatch do
                chars_after_mismatch += 1
                mismatch_2 << char
            end           
            return getReturnMessage(mismatch_1, y1, x1, mismatch_2, y2, x2)

        # (CONTINUE) Characters are identical
        else
            return compare(@copy.nextChar, @orig.nextChar)   
        end
    end
   	def getReturnMessage2(mismatch_1, y1, x1, mismatch_2, y2, x2)
		return ""
	end
    def getReturnMessage(mismatch_1, y1, x1, mismatch_2, y2, x2)
        return    "----------------- mismatch ---------------\n" <<
                "(#{@fileA}:#{y1}:#{x1})\n" <<
                "#{mismatch_1}\n\n" <<
                "(#{@fileB}:#{y2}:#{x2})\n" <<
                "#{mismatch_2}\n" <<
                "------------------------------------------\n"
    end
   
end

class CharGetter
   
    def initialize(file, markup, replacement)
        @file = File.open(file, "r")
        @markup = markup
        @replacement = replacement
       
        @line = ""
        @row_index = 0
        @column_index = 0
		while (@char = nc) =~ @markup do end
       
    end

    def nextChar
        cchar = @char
        if (@char = nc) =~ @markup and cchar =~ @markup then
            return nextChar
        end
       
        if cchar =~ @markup then
            return "#{@replacement}"
        else
            return cchar
        end
    end
   
    def nc
        if @line==nil or @line[@column_index]==nil then
            @line = @file.gets
            @row_index += 1
            @column_index = 0
        end
       
        if @line==nil then
            char = nil
        else
            char = @line[@column_index].chr
        end
       
        @column_index += 1
        return char
    end
   
    def getLine
        return @row_index
    end
   
    def getIndex
        return @column_index
    end
end

CompareMultipleFiles.new('./generated by ASF+SDF/', './target/')
