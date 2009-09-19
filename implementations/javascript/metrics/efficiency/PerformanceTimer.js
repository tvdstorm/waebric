/*****************************************************************************
 * Performance Timer
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/
function PerformanceTimer(){
	
	var startTime;
	var totalTime = 0;
	
	this.start = function(){
		startTime = new Date();		
	}
	
	this.stop = function(){
		var currentTime = new Date();
		totalTime += (currentTime.getTime() - startTime.getTime());	
	}	
	
	this.write = function(path,seperator){		
		//Write file
		var fw = new FileWriter(path, true);
		var bf = new BufferedWriter(fw);
		bf.write(totalTime + seperator);
		bf.close();
		fw.close();
	}
	
	this.stopAndWrite = function(path,seperator){		
		this.stop();
		this.write(path, seperator);
	}
	
	this.getTotalTime = function(){
		return totalTime;
	}
}
