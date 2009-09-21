load('../ometa/rhino/rhino-imports.js')

//Retrieve file paths from argument input (rhino)
for(var itemIndex in arguments){
	var item = arguments[itemIndex];
	if(arguments.hasOwnProperty(itemIndex)){
		OMetaCompiler.compile(item);
	}	
}