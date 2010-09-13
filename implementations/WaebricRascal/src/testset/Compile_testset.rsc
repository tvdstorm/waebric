module testset::Compile_testset

import compiler_rascal_v2::Visit; 
import IO;
import Resources;
import ParseTree;



public void main(){
	set[Resource] inputFiles = getFiles(|folder://WaebricRascal/src/testset/source|);
	for(/file(f) <- inputFiles){
		if(/^.*\/<name:.*>\.wae$/:=f.path){
			println("Compiling ", "\"<name>.wae\"");
			outputFile = |project://WaebricRascal/src/testset/target/<name>.java|;
			doVisit(f,	outputFile);
			println("finished");
		}
	}
}

public set[Resource] getFiles(loc inputDir){
	for(/folder(mp, fs) <- getProject(|folder://WaebricRascal|)){
		if(mp.path==inputDir.path){
			return fs;
		}
	}
	return {};
}