package waebric;

import waebric.node.And;
import waebric.node.Args;
import waebric.node.Argument;
import waebric.node.Argument0;
import waebric.node.Assignment;
import waebric.node.AssignmentList;
import waebric.node.Attri;
import waebric.node.Attribuut;
import waebric.node.AttribuutList;
import waebric.node.Block;
import waebric.node.CData;
import waebric.node.Call;
import waebric.node.Classs;
import waebric.node.Comment;
import waebric.node.Def;
import waebric.node.Designator;
import waebric.node.Designator0;
import waebric.node.Dummy;
import waebric.node.Each;
import waebric.node.Echo;
import waebric.node.EchoEmbedding;
import waebric.node.Embed;
import waebric.node.Embedding;
import waebric.node.Embedding0;
import waebric.node.Empty;
import waebric.node.ExpEmbedding;
import waebric.node.Expression;
import waebric.node.ExpressionList;
import waebric.node.Field;
import waebric.node.Formal;
import waebric.node.Formal0;
import waebric.node.FormalList;
import waebric.node.FuncBind;
import waebric.node.Height;
import waebric.node.Id;
import waebric.node.IfElse;
import waebric.node.Iff;
import waebric.node.ImportDeclaration;
import waebric.node.IsA;
import waebric.node.Keyvaluepair;
import waebric.node.KeyvaluepairList;
import waebric.node.Let;
import waebric.node.List;
import waebric.node.ListType;
import waebric.node.Mapping;
import waebric.node.MappingList;
import waebric.node.Markup;
import waebric.node.Markup0;
import waebric.node.MarkupEmbedding;
import waebric.node.MarkupEmbeddingg;
import waebric.node.MarkupExp;
import waebric.node.MarkupList;
import waebric.node.MarkupMarkup;
import waebric.node.MarkupStat;
import waebric.node.Mid;
import waebric.node.Module;
import waebric.node.ModuleElement;
import waebric.node.ModuleElementList;
import waebric.node.ModuleId;
import waebric.node.Name;
import waebric.node.Not;
import waebric.node.Num;
import waebric.node.Opmaak;
import waebric.node.Or;
import waebric.node.Path;
import waebric.node.Post;
import waebric.node.Pre;
import waebric.node.Predicate;
import waebric.node.Predicate0;
import waebric.node.Record;
import waebric.node.RecordType;
import waebric.node.Site;
import waebric.node.Statement;
import waebric.node.Statement15;
import waebric.node.StatementList;
import waebric.node.StringType;
import waebric.node.Symb;
import waebric.node.SyntaxNode;
import waebric.node.Tag;
import waebric.node.Text;
import waebric.node.Texttail;
import waebric.node.Tiepe;
import waebric.node.Type;
import waebric.node.Var;
import waebric.node.VarBind;
import waebric.node.VisitorAdaptor;
import waebric.node.WidthHeight;
import waebric.node.Yield;

public class PrintAST extends VisitorAdaptor {

	static final String SEP = ", ";
	static final String OPEN = "(";
	static final String CLOSE = ")";
	
	
	public PrintAST() {
		
	}

	protected void cout(Integer i) {
		System.out.print(i.toString());
	}
	
	protected void cout(String s) {
		System.out.print(s);
	}
	
	private void print(SyntaxNode sn) {
	    if (sn != null)
	        sn.accept(this);		
	}
	
	private void printArray(SyntaxNode sn) {
	    cout("[");
	    if (sn != null)
	        sn.accept(this);
	    cout("]");

	}
	
	private String surroundQuotes(String s1) {
	
		return "\""+s1+"\"";
	}
	
	private String replaceControlChars(String s1) {
		
		String s2 = s1;
		s2 = s2.replaceAll("\"","\\\\\"");
		s2 = s2.replace("\n","\\n");
		s2 = s2.replace("\r","\\r");
		s2 = s2.replace("\t","\\t");
		s2 = s2.replace("\f","\\f");
		s2 = s2.replace("&amp;", "&"); // hack om output te kunnen vergelijken
		return s2;
	}
	
	public void visit(And a) {

		cout("and"+OPEN);
		print(a.p1);
		cout(SEP);
		print(a.p2);
		cout(CLOSE);
	}
	
	public void visit(Args a) {

		cout("args([");
	    for (int i = 0; i < a.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	    	
	    	
	    	print((Argument) a.elementAt(i));
	    }
	    cout("])");
	}
	
	public void visit(Argument a) {
		// abstract super class
	}
	
	public void visit(Argument0 a) {

		print(a.e);
	}
	
	public void visit(AssignmentList l) {
		
	    for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	   
	    	
	    	print((Assignment) l.elementAt(i));
	    }
	}
	
	public void visit(Attri a) {
		
		cout("attr"+OPEN);
		cout("\""+a.id+"\"");
		cout(SEP);
		print(a.expr);
		cout(CLOSE);
	}
	
	public void visit(Attribuut a) {
		// abstract super class
	}
	
	public void visit(AttribuutList l) {
		
	    for (int i = 0; i < l.size(); i++) {

	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	    	
	    	
	    	print((Attribuut) l.elementAt(i));
	    }
	}
	
	public void visit(Block b) {
		
		cout("block"+OPEN);
		printArray(b.statementList);
		cout(CLOSE);
	}
	
	public void visit(Call c) {
		
	    cout("call"+OPEN);
	    print(c.d);
	    cout(SEP);
	    print(c.args);
	    cout(CLOSE);
	}
	
	public void visit(CData c) {
		
	    cout("cdata"+OPEN);
	    print(c.e);
	    cout(CLOSE);
	}
	
	public void visit(Classs c) {

	    cout("class"+OPEN);
	    cout(c.idCon);
	    cout(CLOSE);
	}
	
	public void visit(Comment c) {
		
		cout("comment"+OPEN);
		cout(c.id);
		cout(CLOSE);
	}
	
	public void visit(Def d) {
		
	    cout("def"+OPEN);
	    cout("\""+d.id+"\"");
	    cout(SEP);
	    print(d.formalList);
	    cout(SEP);
	    printArray(d.statementList);
	    cout(CLOSE);
	}

	public void visit(Designator d) {
		// abstract super class
	}
	
	public void visit(Designator0 d) {
		print(d.dummy);
	}
	
	public void visit(Dummy d) {
		// leeg
	}
	
	public void visit(Each e) {
		
		cout("each"+OPEN);
		cout(e.id);
		cout(SEP);
		print(e.e);
		cout(SEP);
		print(e.s);
		cout(CLOSE);
	}
	
	public void visit(Echo e) {
		
		cout("echo"+OPEN);
		print(e.e);
		cout(CLOSE);
	}
	
	public void visit(EchoEmbedding e) {
		
		cout("echo-embedding"+OPEN);
		print(e.e);
		cout(CLOSE);
	}

	public void visit(Embed e) {
		// abstract super class
	}
	
	public void visit(Embedding e) {
		// abstract super class
	}
	
	public void visit(Embedding0 e) {
		
		print(e.embedding);
	}
	
	public void visit(Empty e) {
		
		cout("empty");
	}
	
	public void visit(ExpEmbedding e) {
		
		cout("exp-embedding"+OPEN);
		printArray(e.ml);
		cout(SEP);
		print(e.e);
		cout(CLOSE);
	}
	
	public void visit(Expression e) {
		// abstract super class
	}
	
	public void visit(ExpressionList l) {
		
	    for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}
	    	
	    	print((Expression) l.elementAt(i));
	    }
	}
	
	public void visit(Field f) {		
		cout("field"+OPEN);
		print(f.expression);
		cout(SEP);
		cout(f.string);
		cout(CLOSE);
	}
	
	public void visit(Formal f) {
		// abstract super class
	}
	
	public void visit(Formal0 f) {
		
		cout("\""+f.idcon+"\"");
	}
	
	public void visit(FormalList l) {
		
		// Dit is tot nu toe de enige "cons" die niet als node wordt uitgeprint
		// cout("formals(");
		
	    for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}
	    	
	    	print((Formal) l.elementAt(i));
	    }
	    
	    // cout(CLOSE);
	}
	
	public void visit(FuncBind f) {
		
		cout("func-bind"+OPEN);
		cout("\""+f.id+"\"");
		cout(SEP);
		printArray(f.fl);
		cout(SEP);
		print(f.s);
		cout(CLOSE);
	}
	
	public void visit(Height h) {
		
	    cout("height"+OPEN);
	    cout(h.num);
	    cout(CLOSE);
	}
	
	public void visit(Id i) {
		
	    cout("id"+OPEN);
	    cout(i.idCon);
	    cout(CLOSE);		
	}
	
	public void visit(IfElse i) {
		
		cout("if-else"+OPEN);
		print(i.p);
		cout(SEP);
		print(i.s1);
		cout(SEP);
		print(i.s2);
		cout(CLOSE);
	}
	
	public void visit(Iff i) {
		
		cout("if"+OPEN);
		print(i.p);
		cout(SEP);
		print(i.s);
		cout(CLOSE);
	}
	
	public void visit(ImportDeclaration i) {

	    cout("import"+OPEN);
	    print(i.id);
	    cout(CLOSE);	
	}
	
	public void visit(IsA i) {
	    
		cout("is-a"+OPEN);
		print(i.e);
		cout(SEP);
		print(i.t);
		cout(CLOSE);
	}
	
	public void visit(Keyvaluepair k) {
		
		cout("pair"+OPEN);
		cout(k.id);
		cout(SEP);
		print(k.e);
		cout(CLOSE);
	}
	
	public void visit(KeyvaluepairList l) {
		
	    for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}
	    	
	    	print((Keyvaluepair) l.elementAt(i));
	    }
	}
	
	public void visit(Let l) {
		
		cout("let"+OPEN);
		printArray(l.ap);
		cout(SEP);
		printArray(l.as);
		cout(CLOSE);
	}
	
	public void visit(List l) {
	
	    cout("list"+OPEN);
	    printArray(l.expressionList);
	    cout(CLOSE);
	}
	
	public void visit(ListType l) {
		
		cout("list-type");
	}
	
	public void visit(Mapping m) {

	    cout("mapping"+OPEN);
	    print(m.path); // Path
	    cout(SEP);
	    print(m.markup);
	    cout(CLOSE);		
	}
		
	public void visit(MappingList l) {

	    for (int i = 0; i < l.size(); i++) {
	    	if (i>0) {
	    		cout(SEP);
	    	}	    	
	    	
	      print((Mapping) l.elementAt(i));
	    }		
	}
	
	public void visit(Markup m) {
		// abstract super class
	}
	
	public void visit(Markup0 m) {
		
		print(m.designator);
	}
	
	public void visit(MarkupEmbedding m) {
		
		cout("markup-embedding"+OPEN);
		printArray(m.ml);
		cout(SEP);
		print(m.m);
		cout(CLOSE);
	}

	public void visit(MarkupEmbeddingg m) {
		
		cout("markup-embedding"+OPEN);
		printArray(m.ml);
		cout(SEP);
		print(m.e);
		cout(CLOSE);
	}
	
	public void visit(MarkupExp m) {
		
		cout("markup-exp"+OPEN);
		printArray(m.ml);
		cout(SEP);
		print(m.e);
		cout(CLOSE);
	}
	
	public void visit(MarkupList l) {
		
	    for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	    	
	    	
	    	print((Markup) l.elementAt(i));
	    }
		
	}
	
	public void visit(MarkupMarkup mm) {

	    cout("markup-markup"+OPEN);
	    printArray(mm.ml);
	    cout(SEP);
	    print(mm.m);
	    cout(CLOSE);
	}
	
	public void visit(MarkupStat m) {
		
	    cout("markup-stat"+OPEN);
	    printArray(m.ml);
	    cout(SEP);
	    print(m.s);
	    cout(CLOSE);
	}
	
	public void visit(Mid m) {
		
		cout("mid"+OPEN);
		cout(surroundQuotes(replaceControlChars(m.text)));
		cout(SEP);
		print(m.e);
		cout(SEP);
		print(m.t);
		cout(CLOSE);
	}
	
	public void visit(Module m) {
		
	    cout("module"+OPEN);
	    
	    print(m.moduleId);
	    cout(SEP);
	    printArray(m.moduleElementList);
	    
	    cout(CLOSE);
	}
	
	public void visit(ModuleElement m) {
		// abstract super class
	}
	
	public void visit(ModuleElementList l) {

	    for (int i = 0; i < l.size(); i++) {

	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}
	    	print((ModuleElement) l.elementAt(i));
	    }
	}
	
	public void visit(ModuleId id) {
	    cout("module-id([");

	    for (int i = 0; i < id.size(); i++) {

	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	    	

	    	cout("\""+id.elementAt(i)+"\"");
	    }
	    cout("])");		
	}
	
	public void visit(Name n) {

	    cout("name"+OPEN);
	    cout(n.idCon);
	    cout(CLOSE);
	}
	
	public void visit(Not n) {
		
		cout("not"+OPEN);
		print(n.p);
		cout(CLOSE);
	}
	
	public void visit(Num n) {
		
	    cout("num"+OPEN);
	    cout(n.id);
	    cout(CLOSE);
	}

	public void visit(Opmaak o) {
	
	    cout("markup"+OPEN);
	    print(o.m);
	    cout(CLOSE);
	}
	
	public void visit(Or o) {
		
		cout("or"+OPEN);
		print(o.p1);
		cout(SEP);
		print(o.p2);
		cout(CLOSE);
	}
	
	public void visit(Path p) {

		cout("path"+OPEN);
	    cout("\""+p.dir+"\"");
	    cout(SEP);
	    cout("\""+p.filename+"\"");
	    cout(CLOSE);
	}
	
	public void visit(Post p) {
		
		cout("post"+OPEN);
		cout(surroundQuotes(replaceControlChars(p.text)));
		cout(CLOSE);
	}
	
	public void visit(Pre p) {
		
		cout("pre"+OPEN);
		cout(surroundQuotes(replaceControlChars(p.text)));
		cout(SEP);
		print(p.e);
		cout(SEP);
		print(p.t);
		cout(CLOSE);
	}
	
	public void visit(Predicate p) {
		// abstract super class
	}
	
	public void visit(Predicate0 p) {

		print(p.e);
	}
	
	public void visit(Record r) {

	    cout("record"+OPEN);
	    printArray(r.keyvaluepairList);
	    cout(CLOSE);
	}
	
	public void visit(RecordType r) {
		
		cout("record-type");
	}
	
	public void visit(Site s) {
		
	    cout("site"+OPEN);
	    printArray(s.m);
	    cout(CLOSE);
	}
	
	public void visit(Statement s) {
		// abstract super class
	}
	
	public void visit(Statement15 s) {
		
		printArray(s.markupList);
		cout(SEP);
		print(s.statement);
		cout(CLOSE);
	}
	
	public void visit(StatementList l) {
		
		for (int i = 0; i < l.size(); i++) {
	    	
	    	// place separator for 2+ item
	    	if (i>0) {
	    		cout(SEP);
	    	}	   
	    	
	    	print((Statement) l.elementAt(i));
	    }
	}

	public void visit(StringType s) {
		
		cout("string-type");
	}
	
	public void visit(Symb s) {
		
	    cout("sym"+OPEN);
	    cout("\""+s.id+"\"");
	    cout(CLOSE);		
	}
	
	public void visit(Tag t) {

	    cout("tag"+OPEN);
	    cout("\""+t.id+"\"");
	    cout(SEP);
	    printArray(t.attribuutList);
	    cout(CLOSE);
	}
	
	public void visit(Text t) {
		
	    cout("text"+OPEN);
	    cout(surroundQuotes(replaceControlChars(t.id)));
	    cout(CLOSE);
	}
	
	public void visit(Texttail t) {
		// abstract super class
	}
	
	public void visit(Tiepe t) {
		// abstract super class
	}
	
	public void visit(Type t) {

	    cout("type"+OPEN);
	    cout(t.idCon);
	    cout(CLOSE);
	}
	
	public void visit(Var v) {

	    cout("var"+OPEN);
	    cout("\""+v.id+"\"");
	    cout(CLOSE);
	}
	
	public void visit(VarBind v) {
		
		cout("var-bind"+OPEN);
		cout(v.id);
		cout(SEP);
		print(v.e);
		cout(CLOSE);
	}
	
	public void visit(WidthHeight wh) {
		
		cout("width-height"+OPEN);
		cout(wh.w);
		cout(SEP);
		cout(wh.h);
		cout(CLOSE);
		
	}
	
	public void visit(Yield y) {
		cout("yield");
	}
}
