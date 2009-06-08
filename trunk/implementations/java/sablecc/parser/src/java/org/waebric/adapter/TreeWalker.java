package org.waebric.adapter;

import java.util.Iterator;
import java.util.LinkedList;

import org.sablecc.grammar.waebric.analysis.DepthFirstAdapter;
import org.sablecc.grammar.waebric.node.AAndPredicate;
import org.sablecc.grammar.waebric.node.AArgs;
import org.sablecc.grammar.waebric.node.AAttrArgument;
import org.sablecc.grammar.waebric.node.ABlockStatement;
import org.sablecc.grammar.waebric.node.ACallMarkup;
import org.sablecc.grammar.waebric.node.ACatExpression;
import org.sablecc.grammar.waebric.node.ACdataStatement;
import org.sablecc.grammar.waebric.node.AClassAttribute;
import org.sablecc.grammar.waebric.node.ACommentStatement;
import org.sablecc.grammar.waebric.node.ADefModuleElement;
import org.sablecc.grammar.waebric.node.ADesignatorMarkup;
import org.sablecc.grammar.waebric.node.AEachStatement;
import org.sablecc.grammar.waebric.node.AEchoEmbeddingStatement;
import org.sablecc.grammar.waebric.node.AEchoStatement;
import org.sablecc.grammar.waebric.node.AExpEmbeddingEmbed;
import org.sablecc.grammar.waebric.node.AExpressionArgument;
import org.sablecc.grammar.waebric.node.AExpressionPredicate;
import org.sablecc.grammar.waebric.node.AFieldExpression;
import org.sablecc.grammar.waebric.node.AFormals;
import org.sablecc.grammar.waebric.node.AFuncBindAssignment;
import org.sablecc.grammar.waebric.node.AHeightAttribute;
import org.sablecc.grammar.waebric.node.AIdAttribute;
import org.sablecc.grammar.waebric.node.AIfElseStatement;
import org.sablecc.grammar.waebric.node.AIfStatement;
import org.sablecc.grammar.waebric.node.AImportModuleElement;
import org.sablecc.grammar.waebric.node.AIsAPredicate;
import org.sablecc.grammar.waebric.node.ALetStatement;
import org.sablecc.grammar.waebric.node.AListExpression;
import org.sablecc.grammar.waebric.node.AListType;
import org.sablecc.grammar.waebric.node.AMapping;
import org.sablecc.grammar.waebric.node.AMarkupEmbeddingEmbed;
import org.sablecc.grammar.waebric.node.AMarkupEmbeddingStatement;
import org.sablecc.grammar.waebric.node.AMarkupExpStatement;
import org.sablecc.grammar.waebric.node.AMarkupMarkupStatement;
import org.sablecc.grammar.waebric.node.AMarkupStatStatement;
import org.sablecc.grammar.waebric.node.AMarkupStatement;
import org.sablecc.grammar.waebric.node.AMidTextTail;
import org.sablecc.grammar.waebric.node.AModule;
import org.sablecc.grammar.waebric.node.AModuleId;
import org.sablecc.grammar.waebric.node.ANameAttribute;
import org.sablecc.grammar.waebric.node.ANotPredicate;
import org.sablecc.grammar.waebric.node.ANumExpression;
import org.sablecc.grammar.waebric.node.AOrPredicate;
import org.sablecc.grammar.waebric.node.APair;
import org.sablecc.grammar.waebric.node.APath;
import org.sablecc.grammar.waebric.node.APostTextTail;
import org.sablecc.grammar.waebric.node.APreEmbedding;
import org.sablecc.grammar.waebric.node.ARecordExpression;
import org.sablecc.grammar.waebric.node.ARecordType;
import org.sablecc.grammar.waebric.node.ASiteModuleElement;
import org.sablecc.grammar.waebric.node.AStringType;
import org.sablecc.grammar.waebric.node.ASymExpression;
import org.sablecc.grammar.waebric.node.ATagDesignator;
import org.sablecc.grammar.waebric.node.ATextExpression;
import org.sablecc.grammar.waebric.node.ATypeAttribute;
import org.sablecc.grammar.waebric.node.AVarBindAssignment;
import org.sablecc.grammar.waebric.node.AVarExpression;
import org.sablecc.grammar.waebric.node.AWidthHeightAttribute;
import org.sablecc.grammar.waebric.node.AYieldStatement;
import org.sablecc.grammar.waebric.node.Node;
import org.sablecc.grammar.waebric.node.Start;
import org.sablecc.grammar.waebric.node.TFilename;
import org.sablecc.grammar.waebric.node.TIdCon;
import org.sablecc.grammar.waebric.node.TList;
import org.sablecc.grammar.waebric.node.TMidText;
import org.sablecc.grammar.waebric.node.TNatCon;
import org.sablecc.grammar.waebric.node.TPostText;
import org.sablecc.grammar.waebric.node.TPreText;
import org.sablecc.grammar.waebric.node.TRecord;
import org.sablecc.grammar.waebric.node.TStrCon;
import org.sablecc.grammar.waebric.node.TString;
import org.sablecc.grammar.waebric.node.TSymbolCon;
import org.sablecc.grammar.waebric.node.TText;

public class TreeWalker extends DepthFirstAdapter {
    
    private static final int ORIGINAL_ITEM = 0;
    private static final int REPLACEMENT_ITEM = 1;
    
    private static final String ELEMENT_DIVIDER = ", ";
    private static final String[][] ELEMENT_ESCAPE = {
	{"\"", "\\\\\""}, 
	{"\r", "\\\\r"}, 
	{"\n", "\\\\n"}, 
	{"\t", "\\\\t"}
    };
    
    private StringBuilder astTree;

    @Override
    public void inStart(Start node) {
	astTree = new StringBuilder();
    }

    @Override
    public void outStart(Start node) {
	System.out.println(astTree.toString());
    }

    @Override
    public void caseTIdCon(TIdCon node) {
	processValueToken(node.getText());
    }
    
    @Override
    public void caseTStrCon(TStrCon node) {
	processValueToken(node.getText());
    }
    
    @Override
    public void caseTNatCon(TNatCon node) {
	processValueToken(node.getText());
    }
    
    @Override
    public void caseTList(TList node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTRecord(TRecord node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTString(TString node) {
	processValueToken(node.getText());
    }
    
    @Override
    public void caseTSymbolCon(TSymbolCon node) {
	processValueToken(node.getText());
    }
    
    @Override
    public void caseTFilename(TFilename node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTMidText(TMidText node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTPostText(TPostText node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTPreText(TPreText node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseTText(TText node) {
	processValueToken(node.getText());
    }

    @Override
    public void caseAModule(AModule node)
    {
	astTree.append("module(");
	
        if(node.getId() != null)
            node.getId().apply(this);
        
        // Start of module content
        astTree.append(ELEMENT_DIVIDER);
        
        processChildren(node.getElement());

        astTree.append(")");
    }

    @Override
    public void caseAModuleId(AModuleId node) {
	astTree.append("module-id(");
	
	processChildren(node.getId());
	
	astTree.append(")");
    }

    @Override
    public void caseAImportModuleElement(AImportModuleElement node) {
	astTree.append("import(");
	
	if (node.getModuleId() != null)
	    node.getModuleId().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseADefModuleElement(ADefModuleElement node) {
	astTree.append("def(");
	
	if (node.getIdCon() != null) {
	    node.getIdCon().apply(this);
	    astTree.append(ELEMENT_DIVIDER);
	}
	
	if (node.getFormals() == null)
	    astTree.append("empty");
	else
	    node.getFormals().apply(this);
	
	astTree.append(ELEMENT_DIVIDER);
	
	processChildren(node.getStatement());
	
	astTree.append(")");
    }

    @Override
    public void caseAFormals(AFormals node) {
	astTree.append("formals(");
	
	processChildren(node.getIdCon());
	
	astTree.append(")");
    }
    
    @Override
    public void caseAMarkupStatStatement(AMarkupStatStatement node) {
	astTree.append("markup-stat(");
	
    	processChildren(node.getMarkup());
    	
    	astTree.append(ELEMENT_DIVIDER);
    	
    	if (node.getStatement() != null)
    	    node.getStatement().apply(this);
    
	astTree.append(")");
    }
    
    @Override
    public void caseATagDesignator(ATagDesignator node) {
	astTree.append("tag(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(ELEMENT_DIVIDER);
	
	processChildren(node.getAttribute());
	
	astTree.append(")");
    }
    
    @Override
    public void caseAAndPredicate(AAndPredicate node) {
	astTree.append("and(");
	
	if (node.getLeft() != null)
	    node.getLeft().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getRight() != null)
	    node.getRight().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAArgs(AArgs node) {
	astTree.append("args(");
	processChildren(node.getArgument());	
	astTree.append(")");
    }

    

    @Override
    public void caseAAttrArgument(AAttrArgument node) {
	astTree.append("attr(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(")");
    }

    @Override
    public void caseABlockStatement(ABlockStatement node) {
	astTree.append("block(");
	processChildren(node.getStatement());
	astTree.append(")");
    }

    @Override
    public void caseACallMarkup(ACallMarkup node) {
	astTree.append("call(");
	
	if (node.getDesignator() != null)
	    node.getDesignator().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getArgs() != null)
	    node.getArgs().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseACatExpression(ACatExpression node) {
	astTree.append("cat(");
	
	if (node.getL() != null)
	    node.getL().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getR() != null)
	    node.getR().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseACdataStatement(ACdataStatement node) {
	astTree.append("cdata(");
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAClassAttribute(AClassAttribute node) {
	astTree.append("class(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseACommentStatement(ACommentStatement node) {
	astTree.append("comment(");
	
	if (node.getStrCon() != null)
	    node.getStrCon().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseADesignatorMarkup(ADesignatorMarkup node) {
	if (node.getDesignator() != null)
	    node.getDesignator().apply(this);
    }

    @Override
    public void caseAEachStatement(AEachStatement node) {
	astTree.append("each(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(ELEMENT_DIVIDER);
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getStatement() != null)
	    node.getStatement().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAEchoEmbeddingStatement(AEchoEmbeddingStatement node) {
	astTree.append("echo-embedding(");
	
	if (node.getEmbedding() != null)
	    node.getEmbedding().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAEchoStatement(AEchoStatement node) {
	astTree.append("echo(");
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAExpEmbeddingEmbed(AExpEmbeddingEmbed node) {
	astTree.append("exp-embedding(");
	
	processChildren(node.getMarkup());

	astTree.append(ELEMENT_DIVIDER);

	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(")");
    }

    @Override
    public void caseAExpressionArgument(AExpressionArgument node) {
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);
    }

    @Override
    public void caseAExpressionPredicate(AExpressionPredicate node) {
	astTree.append('[');
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(']');
    }

    @Override
    public void caseAFieldExpression(AFieldExpression node) {
	astTree.append("field(");
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(')');
    }

    @Override
    public void caseAFuncBindAssignment(AFuncBindAssignment node) {
	astTree.append("func-bind(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getFormals() != null)
	    node.getFormals().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getStatement() != null)
	    node.getStatement().apply(this);
	
	astTree.append(')');
    }

    @Override
    public void caseAHeightAttribute(AHeightAttribute node) {
	astTree.append("height(");

	if (node.getHeight() != null)
	    node.getHeight().apply(this);
	
	astTree.append(')');
    }

    @Override
    public void caseAIdAttribute(AIdAttribute node) {
	astTree.append("id(");

	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAIfElseStatement(AIfElseStatement node) {
	astTree.append("if-else(");

	if (node.getPredicate() != null)
	    node.getPredicate().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getThenbranch() != null)
	    node.getThenbranch().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getElsebranch() != null)
	    node.getElsebranch().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAIfStatement(AIfStatement node) {
	astTree.append("if(");

	if (node.getPredicate() != null)
	    node.getPredicate().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getStatement() != null)
	    node.getStatement().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAIsAPredicate(AIsAPredicate node) {
	astTree.append("is-a(");

	if (node.getExpression() != null)
	    node.getExpression().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getType() != null)
	    node.getType().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseALetStatement(ALetStatement node) {
	astTree.append("let(");
	processChildren(node.getAssignment());
	astTree.append(ELEMENT_DIVIDER);
	processChildren(node.getStatement());
	astTree.append(')');	
    }

    @Override
    public void caseAListExpression(AListExpression node) {
	astTree.append("list(");
	processChildren(node.getExpression());
	astTree.append(')');	
    }

    @Override
    public void caseAListType(AListType node) {
	astTree.append("list-type(");
	
	if (node.getList() != null)
	    node.getList().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAMapping(AMapping node) {
	astTree.append("mapping(");
	
	if (node.getPath() != null)
	    node.getPath().apply(this);
	
	astTree.append(ELEMENT_DIVIDER);
	
	if (node.getMarkup() != null)
	    node.getMarkup().apply(this);

	astTree.append(')');	
    }

    @Override
    public void caseAMarkupEmbeddingEmbed(AMarkupEmbeddingEmbed node) {
	astTree.append("markup-embedding(");
	processChildren(node.getHead());

	astTree.append(ELEMENT_DIVIDER);

	if (node.getTail() != null)
	    node.getTail().apply(this);
	astTree.append(')');	
    }

    @Override
    public void caseAMarkupEmbeddingStatement(AMarkupEmbeddingStatement node) {
	astTree.append("markup-embedding(");
	
	processChildren(node.getMarkup());

	astTree.append(ELEMENT_DIVIDER);
	
	if (node.getEmbedding() != null)
	    node.getEmbedding().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAMarkupExpStatement(AMarkupExpStatement node) {
	astTree.append("markup-exp(");
	
	processChildren(node.getMarkup());

	astTree.append(ELEMENT_DIVIDER);
	
	if (node.getExpression() != null)
	    node.getExpression().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAMarkupMarkupStatement(AMarkupMarkupStatement node) {
	astTree.append("markup-markup(");
	
	processChildren(node.getHead());
	
	astTree.append(ELEMENT_DIVIDER);

	if (node.getTail() != null)
	    node.getTail().apply(this);
	astTree.append(')');	
    }

    @Override
    public void caseAMarkupStatement(AMarkupStatement node) {
	astTree.append("markup(");

	if (node.getMarkup() != null)
	    node.getMarkup().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAMidTextTail(AMidTextTail node) {
	astTree.append("mid(");

	if (node.getMidText() != null)
	    node.getMidText().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getEmbed() != null)
	    node.getEmbed().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getTextTail() != null)
	    node.getTextTail().apply(this);

	astTree.append(')');	
    }

    @Override
    public void caseANameAttribute(ANameAttribute node) {
	astTree.append("name(");

	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);

	astTree.append(')');	
    }

    @Override
    public void caseANotPredicate(ANotPredicate node) {
	astTree.append("not(");

	if (node.getPredicate() != null)
	    node.getPredicate().apply(this);

	astTree.append(')');	
    }

    @Override
    public void caseANumExpression(ANumExpression node) {
	astTree.append("num(");

	if (node.getNatCon() != null)
	    node.getNatCon().apply(this);

	astTree.append(')');	
    }

    @Override
    public void caseAOrPredicate(AOrPredicate node) {
	astTree.append("or(");
	
	if (node.getLeft() != null)
	    node.getLeft().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getRight() != null)
	    node.getRight().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAPair(APair node) {
	astTree.append("pair(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getExpression() != null)
	    node.getExpression().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAPath(APath node) {
	astTree.append("path(");
	
	if (node.getFilename() != null) {
	    String filename = node.getFilename().getText();
	    // Remove filename separators
	    filename = filename.substring(1, filename.length() - 1);
	    // Show the filename as decoupled elements
	    String[] elements = filename.split("/");
	    
	    for (int i = 0; i < elements.length; i++) {
		astTree.append("\"" + elements[i] + "\"");
		
		if (i < elements.length - 1)
		    astTree.append(ELEMENT_DIVIDER);
	    }
	}
	
	astTree.append(")");
    }

    @Override
    public void caseAPostTextTail(APostTextTail node) {
	astTree.append("post(");
	
	if (node.getPostText() != null)
	    node.getPostText().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseAPreEmbedding(APreEmbedding node) {
	astTree.append("pre(");
	
	if (node.getPreText() != null)
	    node.getPreText().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getEmbed() != null)
	    node.getEmbed().apply(this);
	
	astTree.append(ELEMENT_DIVIDER);

	if (node.getTextTail() != null)
	    node.getTextTail().apply(this);
	
	astTree.append(")");
    }

    @Override
    public void caseARecordExpression(ARecordExpression node) {
	astTree.append("record(");
	processChildren(node.getPair());
	astTree.append(")");
    }

    @Override
    public void caseARecordType(ARecordType node) {
	astTree.append("record-type(");
	
	if (node.getRecord() != null)
	    node.getRecord().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseASiteModuleElement(ASiteModuleElement node) {
	astTree.append("site(");
	processChildren(node.getMapping());
	astTree.append(')');	
    }

    @Override
    public void caseAStringType(AStringType node) {
	astTree.append("string-type(");
	
	if (node.getString() != null)
	    node.getString().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseASymExpression(ASymExpression node) {
	astTree.append("sym(");
	
	if (node.getSymbolCon() != null)
	    node.getSymbolCon().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseATextExpression(ATextExpression node) {
	astTree.append("text(");
	
	if (node.getText() != null)
	    node.getText().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseATypeAttribute(ATypeAttribute node) {
	astTree.append("type(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAVarBindAssignment(AVarBindAssignment node) {
	astTree.append("var-bind(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getExpression() != null)
	    node.getExpression().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAVarExpression(AVarExpression node) {
	astTree.append("var(");
	
	if (node.getIdCon() != null)
	    node.getIdCon().apply(this);
	
	astTree.append(')');	
    }

    @Override
    public void caseAWidthHeightAttribute(AWidthHeightAttribute node) {
	astTree.append("width-height(");
	
	if (node.getWidth() != null)
	    node.getWidth().apply(this);

	astTree.append(ELEMENT_DIVIDER);

	if (node.getHeight() != null)
	    node.getHeight().apply(this);	
	
	astTree.append(')');	
    }

    @Override
    public void caseAYieldStatement(AYieldStatement node) {
	astTree.append("yield");
    }

    private void processChildren(LinkedList<? extends Node> children) {
	astTree.append('[');
	
    	if (children != null) {	
        	Iterator<? extends Node> iterator = children.iterator();
        	while (iterator.hasNext()) {
        	    Node node = iterator.next();
        	    node.apply(this);
        	    
        	    if (iterator.hasNext())
        		astTree.append(ELEMENT_DIVIDER);
        	}
    	}
	
	astTree.append(']');
    }
    
    private void processValueToken(String text) {
	String s = text;
	for (int replacementId = 0; replacementId < ELEMENT_ESCAPE.length; replacementId++) {
	    s = s.replaceAll(ELEMENT_ESCAPE[replacementId][ORIGINAL_ITEM], ELEMENT_ESCAPE[replacementId][REPLACEMENT_ITEM]);
	}
	    
	astTree.append(String.format("\"%1$s\"", s));
    }
    
}
