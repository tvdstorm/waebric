
public class ParserPreamble {
	public class Environment {
		public static Map<String, Integer> functions;
		public static Map<String, Integer> variables;
	 }
	
	public void mapping() {
		this.document = new Document(); this.current = null;
		try {
			OutputStream os = createOutputStream($PATH.toString());
			if(current != null) { outputDocument(document, os); }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void markup() {
		boolean element;
		boolean yield = false;
		int start = input.index(); int attr = 0; int args = 0;
		attr = input.index();
		args = input.index();
		if(containsFunction($IDCON.getText())) {		
			// Process markup as function call
			int curr = input.index();
			input.seek(args);
			List<Integer> eval = arguments(true).args;
			input.seek(curr);
			
			// Store yield arguments
			if(containsYield($IDCON.getText()) && element) {
				yieldStack.add(start);
				yield = true;
			}
			
			// Start interpreting function
			interpretFunction($IDCON.getText(), eval);
		} else {
			// Process markup as tag
			addContent(new Element($IDCON.getText()));
			
			// Process attributes
			int actual = input.index();
			input.seek(attr);
			attributes();
			arguments(false);
			input.seek(actual);
		}
	}
	
	public void attribute() {
		current.setAttribute("id", $IDCON.getText());
		current.setAttribute("class", $IDCON.getText());
		current.setAttribute("name", $IDCON.getText());
		current.setAttribute("type", $IDCON.getText());
		current.setAttribute("width", $w.getText());
		current.setAttribute("height", $h.getText());
	}
	
	public void arguments() {
		boolean call;
		List<Integer> args = new ArrayList<Integer>();
	}
	
	public void argument() {
		List<Integer> args;
		boolean call;
		if(call) { 
			args.add($expression.index); // Add expression index to argument collection
		} else {
			// Attach argument to value attribute
			Attribute attribute = current.getAttribute("value");
			String value = (attribute == null) ? "" : attribute.getValue() + ", ";
			value += $expression.eval;
			current.setAttribute("value",  value);
		}
		if(call) { 
			 // TODO: Figure out what to do
		} else { 
			if($IDCON.getText().equals("xmlns")) {
				// JDOM won't allow xmlns attributes
				current.setNamespace(Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml"));
			} else { current.setAttribute($IDCON.getText(), $expression.eval); }
		} 
	}
	
	public void expression() {
		int index = -1; // Used for interpreting a referenced variable
		String eval = "undef"; // Evaluation value for printing
		Map<String, expression_return> map = new HashMap<String, expression_return>(); // Map structure for fields
		Collection<expression_return> collection = new ArrayList(); // List structure for iterations
		index = input.index();
		// Reference
		int curr = input.index();
		int next = getVariable($var.getText());
		if(next != -1) {
			input.seek(next);
			retval = expression();
			input.seek(curr);
		} 
		eval = $NATCON.getText();
		eval = $TEXT.getText(); eval = eval.substring(1, eval.length()-1);
		eval = $SYMBOLCON.getText(); eval = eval.substring(1, eval.length());
		collection.add(e);
		collection.add(e);
		eval = "[";
		for(expression_return eret:collection) { eval += eret.eval + ","; }
		eval = eval.substring(0, eval.length()); // Clip last character
		eval += "]";
		map.put($id.getText(), e);
		map.put($id.getText(), e);
		// Build record type string evaluation
		collection = map.values();
		eval = "{";
		for(String key:map.keySet()) { eval += key + ":" + map.get(key).eval + ","; }
		eval = eval.substring(0, eval.length()); // Clip last character
		eval += "}";
		// Expression combination
		eval += e.eval;
		collection.clear();
		map.clear();
		if(map.containsKey($id.getText())) { retval = map.get($id.getText()); } 
		else {
			index = -1;
			eval = "undef";
			collection.clear();
			map.clear();
		}
	}
	
	public void function() {
		List<Integer> args;
		Element actual = null; int curr = 0;
		defineVariable($id.getText(), args.get(curr)); curr++;
		if(actual != null) { this.current = actual; } 
		else { actual = this.current; } 
	}
	
	public void statement() {
		addContent(new Comment($STRCON.getText()));
		addContent(new Text($expression.eval));
		addContent(new CDATA($expression.eval));
		if(! yieldStack.isEmpty()) {
			int curr = input.index();
			int index = yieldStack.pop();
			Stack clone = (Stack) yieldStack.clone();

			input.seek(index);
			matchAny(input); // Skip already interpreted markup
			markupChain(); // Execute copied markup chain
			input.seek(curr);
			
			yieldStack = clone;
		}
		if($markup.yield) { 
			matchAny(input); // Match markup chain, without executing
			match(input, Token.UP, null); // Match up
			return retval; // Quit parsing markup stm
		}
	}
	
	public void markupChain() {
		if($markup.yield) { 
			matchAny(input); // Match markup chain, without executing
			match(input, Token.UP, null); // Match up
			return retval; // Quit parsing markup stm
		}
		addContent(new Text($expression.eval));
	}
	
	public void ifStatement() {
		int ti = 0; int fi = 0;
		ti = input.index();
		fi = input.index();
		int curr = input.index();
		if($predicate.eval) {
			input.seek(ti);
			statement();
			input.seek(curr);
		} else if(f != null) {
			input.seek(fi);
			statement();
			input.seek(curr);
		}
	}
	
	public void eachStatement() {
		Environment.variables = new HashMap<String, Integer>();
		Environment.functions = new HashMap<String, Integer>();
		int stm = 0;
		stm = input.index();
		int actualIndex = input.index();
			Element actualElement = this.current;
			for(expression_return value: e.collection) {
				defineVariable($IDCON.getText(), value.index);
				input.seek(stm);
				statement();
				input.seek(actualIndex);	
				if(actualElement == null) { actualElement = document.getRootElement(); }
				this.current = actualElement;
			}
	}
	
	public void blockStatement() {
		Element actual = this.current;
		if(actual != null) { this.current = actual; } 
		else { actual = this.current; } 
	}
	
	public void letStatement() {
		Environment.variables = new HashMap<String, Integer>();
		Environment.functions = new HashMap<String, Integer>();
		Element actual = this.current;
		if(actual != null) { this.current = actual; } 
		else { actual = this.current; } 
	}
	
	public void varBinding() {
		defineVariable($IDCON.getText(), $expression.index);
	}
	
	public void funcBinding() {
		int index = input.index();
		environments.put($id.getText(), cloneEnvironment());
		defineFunction($id.getText(), index); 
	}
	
	public void predicate() {
		boolean eval;
		eval = ! $p.eval;
		eval = $e.index != -1;
		eval = $e.eval.startsWith("[");
		eval = $e.eval.startsWith("{");
		eval = $e.index != -1;
		eval = eval && $p.eval;
		eval = eval || $p.eval;
	}
	
	public void embedding() {
		addContent(new Text($PRETEXT.getText().substring(1, $PRETEXT.getText().length()-1)));
	}
	
	public void embed() {
		addContent(new Text($expression.eval));
	}
	
	public void textTail() {
		addContent(new Text($POSTTEXT.getText().substring(1, $POSTTEXT.getText().length()-1)));
		addContent(new Text($MIDTEXT.getText().substring(1, $MIDTEXT.getText().length()-1)));
	}
}