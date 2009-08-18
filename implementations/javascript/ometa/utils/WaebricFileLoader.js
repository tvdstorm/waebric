/** 
 * Waebric File Loader
 * 
 * Loads files from the filesystem 
 *   
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function WaebricFileLoader(){
	
	this.loadFile = function(path){		
		var fis = new FileInputStream(path);
		var bis = new BufferedInputStream(fis);
		var dis = new DataInputStream(bis);
		
		var program = '';
		while (dis.available() != 0) {
			program += dis.readLine() + '\n';
		}
		fis.close();
		bis.close();
		dis.close();
		
		return program;
	}
}

WaebricFileLoader.loadFile = function(path){
	var loader = new WaebricFileLoader();
	return loader.loadFile(path);
}