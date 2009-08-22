
public class ScannerAction {
 boolean inSite = false;
 boolean inPath = false;
 boolean inString = false;
 
 public void scan() {
	 inString = true;
	 inSite = true; inPath = true;
	 inSite = false; inPath = false;
	 inPath = inSite;
	 if(inPath) inPath = false;
	 if(inString) inString = false;
	 if(inPath) inPath = false;
	 if(! inPath) {}
 }
}
