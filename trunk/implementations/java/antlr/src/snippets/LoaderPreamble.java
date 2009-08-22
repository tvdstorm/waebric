package org.cwi.waebric;
	import antlr.SemanticException;
	
public class LoaderPreamble {
	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
	private Map<String, function_return> functions = new HashMap<String, function_return>();
	private List<mapping_return> mappings = new ArrayList<mapping_return>();
	private List<Integer> yields = new ArrayList<Integer>();
	
	/**
	 * Walk module to retrieve function definitions and mappings
	 */
	public List<SemanticException> loadModule() throws RecognitionException {
		exceptions.clear();
		functions.clear();
		mappings.clear();
		this.module();
		return exceptions;
	}
		
	public Map<String, function_return> getFunctions() { 
		return functions;
	}
	
	public List<mapping_return> getMappings() { 
		return mappings;
	}
	
	public List<Integer> getYields() {
		return yields;
	}
}
