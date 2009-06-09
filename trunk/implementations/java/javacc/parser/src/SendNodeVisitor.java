public class SendNodeVisitor {
  private enum Productions {
	MODULES, MODULE, MODULEID, MODULEELEMENT, IMPORT, SITE, FUNCTIONDEF, NOVALUE;
    public static Productions toProd(String str) {
	  try {
	    return valueOf(str);
	   } 
	   catch (Exception ex) {
	     return NOVALUE;
	   }
	 }  
  }
  
  private String astData = "";
  private String astSuffix = "";

  public SendNodeVisitor(Node n, int childIndex){
	  doNodeVisit(n, childIndex);
  }
  
  public String getASTData() {
	return astData;
  }
  
  public String getASTSuffix() {
	return astSuffix;
  }
  
  public void doNodeVisit(Node n, int childIndex) {
	String str = n.toString().toUpperCase();
	  
	switch (Productions.toProd(str)) {
	case MODULE:
		astData = "module(";
		astSuffix = "])";
		break;
		
	case MODULEID:
		ModuleIdVisitor v = new ModuleIdVisitor();
	  	n.jjtAccept(v, null);
	  	astData = "module-id(" + v.moduleIdStr + "";
	  	if (n.jjtGetParent().toString().equals("module")) {
	  		astSuffix = ", [";
	  	} else {
	  		astSuffix = "";
	  	}
	  	break;
	  	
	case MODULEELEMENT:
		if (childIndex > 1) {
			astData = ", ";
		}
		break;
		
	case IMPORT:
		astData = "import(";
		astSuffix = ")";
		break;
	}
  }
}
