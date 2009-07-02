parser grammar Module;

import Waebric;

module returns [Module result = new Module()] : 		
	MODULE id=moduleId { $result.setIdentifier(id.result); } ( 	
		i=imprt { $result.addImport(i.result); } |
		s=site { $result.addSite(s.result); } |
		f=function {  }
	)* END ;
