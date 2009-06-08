package org.cwi.waebric.parser;

import java.util.List;

import org.cwi.waebric.WaebricKeyword;
import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.basic.IdCon;
import org.cwi.waebric.parser.ast.module.FunctionDef;
import org.cwi.waebric.parser.ast.module.Import;
import org.cwi.waebric.parser.ast.module.Module;
import org.cwi.waebric.parser.ast.module.ModuleId;
import org.cwi.waebric.parser.ast.module.Modules;
import org.cwi.waebric.parser.ast.module.site.Site;
import org.cwi.waebric.parser.exception.SyntaxException;
import org.cwi.waebric.scanner.token.WaebricTokenIterator;
import org.cwi.waebric.scanner.token.WaebricTokenSort;

/**
 * module languages/waebric/syntax/Modules
 * 
 * @author Jeroen van Schagen
 * @date 20-05-2009
 */
class ModuleParser extends AbstractParser {

	private final SiteParser siteParser;
	private final FunctionParser functionParser;
	
	/**
	 * Construct module parser
	 * @param tokens
	 * @param exceptions
	 */
	public ModuleParser(WaebricTokenIterator tokens, List<SyntaxException> exceptions) {
		super(tokens, exceptions);
		
		// Initialize sub-parsers
		siteParser = new SiteParser(tokens, exceptions);
		functionParser = new FunctionParser(tokens, exceptions);
	}
	
	/**
	 * Module* -> Modules
	 * @throws SyntaxException 
	 */
	public Modules parseModules() throws SyntaxException {
		Modules modules = new Modules();
		
		// Parse Module*
		while(tokens.hasNext()) {
			next(WaebricKeyword.MODULE, "Module", "\"Module\" ModuleId");
			Module module = parseModule(modules);
			modules.add(module);
		}
		
		return modules;
	}
	

	/**
	 * "module" ModuleId ModuleElement* -> Module
	 * @throws SyntaxException
	 */
	public Module parseModule(Modules modules) throws SyntaxException {
		current(WaebricKeyword.MODULE, "Module", "\"Module\" ModuleId");
		
		Module module = new Module();
		module.setIdentifier(parseModuleId());
		
		// Check if module has already been parsed
		if(modules.contains(module)) {
			while(tokens.hasNext() && ! tokens.peek(1).getLexeme().equals(WaebricKeyword.MODULE)) {
				tokens.next(); // Iterate to next module
			}
		}
		
		// ModuleElement*
		while(tokens.hasNext()) {
			if(tokens.peek(1).getLexeme().equals(WaebricKeyword.MODULE)) { 
				break; // Break current module parse, as new module is detected
			}
			
			tokens.next(); // Set current to first module element
			if(tokens.current().getLexeme() == WaebricKeyword.IMPORT) {
				Import imprt = parseImport();
				module.addElement(imprt);
			} else if(tokens.current().getLexeme() == WaebricKeyword.SITE) {
				Site site = siteParser.parseSite();
				module.addElement(site);
			} else if(tokens.current().getLexeme() == WaebricKeyword.DEF) {
				FunctionDef def = functionParser.parseFunctionDef();
				module.addElement(def);
			} else {
				reportUnexpectedToken(tokens.current(), 
					"Module element", "\"import\", \"site\" or \"def\"");
			}
		}
		
		return module;
	}
	
	/**
	 * { IdCon "." }+ -> ModuleId
	 * @throws SyntaxException 
	 */
	public ModuleId parseModuleId() throws SyntaxException {
		ModuleId moduleId = new ModuleId();
		
		do {
			next(WaebricTokenSort.IDCON, "Module identifier", "Identifier");
			moduleId.add(new IdCon(tokens.current().getLexeme().toString()));
			
			// Parse potential separator
			if(tokens.hasNext() && tokens.peek(1).getLexeme().equals(WaebricSymbol.PERIOD)) {
				tokens.next(); // Accept "." and set current to next identifier
			} else {
				break; // No period detected, end of identifier
			}
		} while(tokens.hasNext());
		
		return moduleId;
	}
	
	/**
	 * "import ModuleId -> Import
	 * @throws SyntaxException 
	 */
	public Import parseImport() throws SyntaxException {
		Import imprt = new Import();
		imprt.setIdentifier(parseModuleId());
		return imprt;
	}

}