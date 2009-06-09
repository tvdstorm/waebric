package beaver.comp;

// Author: Allard Dijk

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.DeflaterOutputStream;
import java.util.Hashtable;

import beaver.Parser;
import beaver.comp.io.SrcReader;
import beaver.comp.run.Options;
import beaver.comp.util.BitSet;
import beaver.comp.util.Log;
import beaver.comp.ASTinfo;
import beaver.comp.ASTargument;
import beaver.spec.Grammar;
import beaver.spec.GrammarBuilder;
import beaver.spec.NonTerminal;
import beaver.spec.Production;
import beaver.spec.Terminal;
import beaver.spec.ast.GrammarTreeRoot;
import beaver.spec.parser.GrammarParser;
import beaver.spec.parser.GrammarScanner;

/**
 * This class provides parser generation driving routines. In a way it is a driver, where only top level calls are left
 * for the Main application class.
 */
public class ASTGenerator
{
		static public void create(File dir,Grammar grammar, Options opts) throws IOException
		{
			System.out.println("create AST");
			FileWriter treeWalkerOut = new FileWriter(new File(dir+"/ast/", "TreeWalker.java"));
			Hashtable createdFunctions = new Hashtable();

			try
			{
				String treewalkCode="package waebric.ast;\n\n";
				treewalkCode+="public class TreeWalker\n{\n";
				treewalkCode+=getAddSlashFunction();
				
				

				for (int i = 0; i < grammar.rules.length; i++)
				{
					Production rule = grammar.rules[i];
					if(rule.code==null)
						continue;

					
					if (rule.code.indexOf("//@") >=0  ||
						rule.code.indexOf("//$") >=0  || 
						rule.code.indexOf("//[]") >=0 ||
						rule.code.indexOf("//#") >=0 
						)
					{			
						
						ASTinfo astInfo = new ASTinfo(rule.code);
											
						for (int ruleItemIndex = 0;
						 	ruleItemIndex < rule.rhs.items.length; 
						 	ruleItemIndex++)
						{
							Production.RHS.Item rhs_item = rule.rhs.items[ruleItemIndex];
							if (rhs_item.alias != null)
							{
								if(rhs_item.symbol.type==null)
								{
									rhs_item.symbol.type = astInfo.getBeaverType(rhs_item.alias);
										
								}
							}
							
						}
			
						
						Object oFunctionCreated = (Object)createdFunctions.get(astInfo.className);
					    if (oFunctionCreated == null) {
							FileWriter out = new FileWriter(new File(dir+"/ast/", astInfo.className + ".java"));
							try
							{
									String classCode = getClassCode(astInfo);
									out.write(classCode);
									out.write("\n");
							}
							finally
							{
								out.close();	
							}
		
							treewalkCode += getTreeWalkCode(astInfo);	
							createdFunctions.put(astInfo.className, true );
					    }
						
						
						//astInfo.printArguments();
						String newCode = "return new " + astInfo.newFuncion + ";";
						rule.code = newCode;
						System.out.println(newCode);
					
				}
				}
				treewalkCode+="\n}\n"; //end of TreeWalker class
				treeWalkerOut.write(treewalkCode);
			}
			finally
			{
				treeWalkerOut.close();
			}
	
			System.out.println("createAST finished...");
			
		}
		

	static public String getTreeWalkCodeArray(int currentStringArgumentNumber,int currentConsArgumentNumber, ASTinfo astInfo)
	{
			String sUsedVariable = getTreeWalkVariableName(currentStringArgumentNumber,currentConsArgumentNumber,ASTtype.ARRAY);
			String sUsedSizeVariable = sUsedVariable.replaceAll("\\.","_") + "_size";
			String treewalkCode="";

			treewalkCode = "\t\tint "+sUsedSizeVariable+"=0;\n";
			treewalkCode += "\t\tif("+sUsedVariable+"!=null)\n";
			treewalkCode += "\t\t{\n";
			treewalkCode += "\t\t"+sUsedSizeVariable+"="+sUsedVariable+".size();\n";
			treewalkCode +=	"\t\t}\n";
			treewalkCode +=	"\t\tif("+sUsedSizeVariable+">0)\n";
			treewalkCode +=	"\t\t{\n";
			if(!astInfo.isMultiArray())
			{
				treewalkCode +=	"\t\tSystem.out.print(\"[\");\n";
			}
			treewalkCode +=	"\t\tfor(int index=0;index<"+sUsedSizeVariable+";index++)\n";
			treewalkCode +=	"\t\t{\n";
			treewalkCode +=	"\t\tCons listitem = (Cons)"+sUsedVariable+".get(index);\n";
			treewalkCode +=	"\t\tlistitem.accept(this);\n";
			treewalkCode +=	"\t\tif(index<("+sUsedSizeVariable+"-1))\n";
			treewalkCode +=	"\t\t{\n";
			treewalkCode +=	"\t\tSystem.out.print(\", \");\n";
			treewalkCode +=	"\t\t}\n";
			treewalkCode +=	"\t\t}\n";
			if(!astInfo.isMultiArray())
			{
				treewalkCode +=	"\t\tSystem.out.print(\"]\");\n";
			}
			treewalkCode +=	"\t\t}\n";
			treewalkCode +=	"\t\telse\n";
			treewalkCode +=	"\t\t{\n";
			if(!astInfo.isMultiArray())
			{
				treewalkCode +=	"\t\tSystem.out.print(\"[]\");\n";
			}
			treewalkCode +=	"\t\t}\n";


		return treewalkCode;
	}
	
	
	static public String getTreeWalkCodeCons(int currentStringArgumentNumber,int currentConsArgumentNumber, ASTinfo astInfo)
	{
		String sUsedVariable = getTreeWalkVariableName(currentStringArgumentNumber,currentConsArgumentNumber,ASTtype.CONS);
		String treewalkCode = "\t\tif("+sUsedVariable+"!=null){\n";
		if(astInfo.bStringArray)
		{
			treewalkCode += "\n\t\tSystem.out.print(\"[\");\n\t\t\n";
		}
		treewalkCode += "\t\t\t"+sUsedVariable+".accept(this);\n";
		if(astInfo.bStringArray)
		{
			treewalkCode += "\n\t\tSystem.out.print(\"]\");\n\t\t\n";
		}
		treewalkCode += "\t\t}\n\t\telse{\n";
		treewalkCode += "\t\t\tSystem.out.print(\"[]\");\n";
		treewalkCode += "\t\t}\n";
		return treewalkCode;							
	}
	
	static public String getTreeWalkCodeString(int currentStringArgumentNumber,int currentConsArgumentNumber, ASTinfo astInfo)
	{
		
		String treewalkCode = "\t\t//leaf\n";
		int currentArgumentNr = currentStringArgumentNumber + currentConsArgumentNumber;
		treewalkCode += "\t\tSystem.out.print(";
		if(astInfo.argument[currentArgumentNr].bUseQuotes())
		{
			treewalkCode += "\"\\\"\" + ";
		}
		String varName = getTreeWalkVariableName(currentStringArgumentNumber,
			currentConsArgumentNumber,
			ASTtype.STRING
		);
		treewalkCode += "\n\t\t addSlashes(" + varName + ")\n\t\t";
		if(astInfo.argument[currentArgumentNr].bUseQuotes())
		{
			treewalkCode += "+ \"\\\"\"";
		}
		treewalkCode += ");\n";	
		return treewalkCode;
	}
	
	static public String getExtendClass(ASTinfo astInfo)
	{
		int nrCons= astInfo.getNumberOfCons();
		String extendClass="TwoCons";
		if(nrCons==1)
		{
			if(astInfo.argument[0].astType.equals(ASTtype.CONS))
			{	
				extendClass="OneCons";	
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.ARRAY))
			{
				extendClass="ListType";	
			}

		}
		else if(nrCons==0)
		{
				extendClass="Cons";
		}
		
		if(astInfo.numberOfArguments==2)
		{
			if(astInfo.argument[0].astType.equals(ASTtype.CONS) &&
				astInfo.argument[1].astType.equals(ASTtype.ARRAY))
			{
				extendClass="ConsListType";	
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.ARRAY) &&
				astInfo.argument[1].astType.equals(ASTtype.CONS))
			{
				extendClass="ListTypeCons";	
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.STRING) &&
				astInfo.argument[1].astType.equals(ASTtype.CONS))
			{
				extendClass="OneCons";	
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.STRING) &&
				astInfo.argument[1].astType.equals(ASTtype.ARRAY))
			{
				extendClass="ListType";	
			}
		}
		else if(astInfo.numberOfArguments==3)
		{
			 if(astInfo.argument[0].astType.equals(ASTtype.STRING) &&
			 	astInfo.argument[1].astType.equals(ASTtype.CONS) &&
				astInfo.argument[2].astType.equals(ASTtype.ARRAY))
			{
				extendClass="ConsListType";	
			}
			if(astInfo.argument[0].astType.equals(ASTtype.CONS) &&
			 	astInfo.argument[1].astType.equals(ASTtype.CONS) &&
				astInfo.argument[2].astType.equals(ASTtype.CONS))
			{
				extendClass="ThreeCons";	
			}
		}
		return extendClass;
	}
	
	static public String getSuperConstruction(ASTinfo astInfo)
	{
		int nrCons= astInfo.getNumberOfCons();
		String superConstruction="super(left, right);";
		if(nrCons==3)
		{
			superConstruction="super(left, right, tirth);\n";
		}	
		if(nrCons==2)
		{
			if(astInfo.numberOfArguments==3)
			{
				if(astInfo.argument[0].astType.equals(ASTtype.STRING))
				{
					superConstruction="super(right, tirth);\n";
					superConstruction+="\t\tthis.valueLeft = left;";
				}
				else if(astInfo.argument[1].astType.equals(ASTtype.STRING))
				{
					superConstruction="super(left, tirth);\n";
					superConstruction+="\t\tthis.valueRight = right;";
				}
				else if(astInfo.argument[2].astType.equals(ASTtype.STRING))
				{
					superConstruction="super(left, right);\n";
					superConstruction+="\t\tthis.valueTirth = tirth;";
				}
			}
		}
		else if(nrCons==1)
		{
			if(astInfo.numberOfArguments>=2)
			{
				if(astInfo.argument[0].isNode())
				{
					superConstruction="super(left);\n";
					superConstruction+="\t\tthis.valueRight = right;";
				}
				if(astInfo.argument[1].isNode())
				{
					superConstruction="super(right);\n";
					superConstruction+="\t\tthis.valueLeft = left;";
				}
			}
			else if(astInfo.numberOfArguments==1)
			{
				if(astInfo.argument[0].isNode() )
				{
					superConstruction="super(left);\n";
				}
				else if(astInfo.argument[0].astType.equals(ASTtype.STRING))
				{	
					System.out.println("String...");
					superConstruction="super();\n";
					superConstruction+="\t\tthis.valueLeft = left;";
				}
			}
			
		}
		else if(nrCons==0)
		{
			superConstruction="super();\n";
			if(astInfo.numberOfArguments>=1)
			{
				superConstruction+="\t\tthis.valueLeft = left;\n";

			}
			if(astInfo.numberOfArguments>=2)
			{
				superConstruction+="\t\tthis.valueRight = right;\n";
			}
		}
		
		return superConstruction;
	}
	
	static public String getStringVariables(ASTinfo astInfo)
	{
		String stringVariables="";
		if(astInfo.numberOfArguments>=1)
		{
			if(astInfo.argument[0].astType.equals(ASTtype.STRING))
			{		
				stringVariables = "\tpublic final String valueLeft;\n";
			}
		}
		if(astInfo.numberOfArguments>=2)
		{
			if(astInfo.argument[1].astType.equals(ASTtype.STRING))
			{
				stringVariables += "\tpublic final String valueRight;\n";
			}
		}
		if(astInfo.numberOfArguments>=3)
		{
			if(astInfo.argument[2].astType.equals(ASTtype.STRING))
			{
				stringVariables += "\tpublic final String valueTirth;\n";
			}
		}
					
		return stringVariables;
	}

	static public String getClassCode(ASTinfo astInfo)
	{
		String classCode="package waebric.ast;\n\n";
		
		for (int argumentIndex=0;argumentIndex<astInfo.numberOfArguments;argumentIndex++)
		{
			if( astInfo.argument[argumentIndex].astType.equals(ASTtype.ARRAY) )
			{
				classCode +="\nimport java.util.ArrayList;\n";
				classCode +="import java.util.Collection;\n\n";
				break; //just add this imports once
			}
		}

		 
		

		classCode += "\npublic class "+astInfo.className+" extends " + getExtendClass(astInfo) + "\n";
	    classCode += "{\n";
	    classCode += getStringVariables(astInfo);
	    
	    classCode += "\tpublic " + astInfo.className+ "(";
	    
	    if(astInfo.numberOfArguments>=1)
	    {
	    	classCode += astInfo.argument[0].sGetType() + " left";
	    }
	   	if(astInfo.numberOfArguments>=2)
	    {
	    	classCode += ", " + astInfo.argument[1].sGetType() + " right";
	    }
	    if(astInfo.numberOfArguments>=3)
	    {
	    	classCode += ", " + astInfo.argument[2].sGetType() + " tirth";
	    }
	    

	    classCode += ")\n";
		classCode += "\t{\n";
		classCode += "\t\t"+ getSuperConstruction(astInfo) +"\n";
		classCode += astInfo.stringBoolean;
		classCode += "\t}\n";
		
		classCode += "\n\tpublic void accept(TreeWalker walker)\n";
		classCode += "\t{\n";
		classCode += "\t\twalker.visit(this);\n";
		classCode += "\t}\n";
		classCode += "}\n";
		
		return classCode;
	}
	
	static public String getTreeWalkCode(ASTinfo astInfo)
	{
		String treewalkCode="";
						
		treewalkCode += "\tpublic void visit("+ astInfo.className +" cons)\n";
		treewalkCode += "\t{\n";
		
		if(astInfo.isMultiArray())
		{
			treewalkCode += "\t\tSystem.out.print(\"[\");\n";
		}
		
		int currentConsArgumentNumber=0;
		int currentStringArgumentNumber=0;
		
		if( astInfo.isKnoopPunt() ) 
		{
			treewalkCode += "\t\tSystem.out.print(\""+astInfo.ASTname;
			//haakje alleen uitprinten als dit niet het eindpunt is van een traversal
			if(astInfo.numberOfArguments>0)
			{
				treewalkCode += "("; 
			}
			treewalkCode += "\");\n";
		}
		
		if(astInfo.numberOfArguments==0)
		{
			treewalkCode += "\t\t//leaf\n";
		}

	    if(astInfo.numberOfArguments==1)
	    {
 			if(astInfo.argument[0].astType.equals(ASTtype.STRING))
			{
				treewalkCode += getTreeWalkCodeString( currentStringArgumentNumber, currentConsArgumentNumber, astInfo  ); // "cons.valueLeft"
				currentStringArgumentNumber++;
				treewalkCode += "\t\t//leaf\n";
				
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.CONS))
			{			
				treewalkCode += getTreeWalkCodeCons( currentStringArgumentNumber, currentConsArgumentNumber ,astInfo); //"cons.l"
				currentConsArgumentNumber++;
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.ARRAY))
			{
				treewalkCode += getTreeWalkCodeArray( currentStringArgumentNumber, currentConsArgumentNumber, astInfo ); //"cons.l","lArraySize"
				currentConsArgumentNumber++;
			}
	    }
	    else if(astInfo.numberOfArguments>=2)
	    {
			
			if(astInfo.argument[0].astType.equals(ASTtype.CONS))
			{
				treewalkCode += getTreeWalkCodeCons( currentStringArgumentNumber, currentConsArgumentNumber ,astInfo);
				currentConsArgumentNumber++;
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.STRING))
			{
	
				treewalkCode += getTreeWalkCodeString( currentStringArgumentNumber, currentConsArgumentNumber, astInfo  ); // "cons.valueLeft"
				currentStringArgumentNumber++;
			}
			else if(astInfo.argument[0].astType.equals(ASTtype.ARRAY))
			{
				treewalkCode += getTreeWalkCodeArray( currentStringArgumentNumber, currentConsArgumentNumber, astInfo ); //"cons.l","lArraySize"
				currentConsArgumentNumber++;
			}
		
			treewalkCode += "\t\tSystem.out.print(\", \");\n";
		
			if(astInfo.argument[1].astType.equals(ASTtype.CONS))
			{
				treewalkCode += getTreeWalkCodeCons(currentStringArgumentNumber, currentConsArgumentNumber ,astInfo); // "cons.r"
				currentConsArgumentNumber++;
			}
			else if(astInfo.argument[1].astType.equals(ASTtype.STRING))
			{
				treewalkCode += getTreeWalkCodeString( currentStringArgumentNumber, currentConsArgumentNumber, astInfo  ); // "cons.valueRight"
				currentStringArgumentNumber++;
			}
			else if(astInfo.argument[1].astType.equals(ASTtype.ARRAY))
			{
				treewalkCode += getTreeWalkCodeArray( currentStringArgumentNumber, currentConsArgumentNumber, astInfo ); // "cons.r","rArraySize"
				currentConsArgumentNumber++;
			}
			
			if(astInfo.numberOfArguments>=3)
	    	{
				treewalkCode += "\t\tSystem.out.print(\", \");\n";
			
				if(astInfo.argument[2].astType.equals(ASTtype.CONS))
				{
					treewalkCode += getTreeWalkCodeCons( currentStringArgumentNumber, currentConsArgumentNumber ,astInfo); // "cons.r"
					currentConsArgumentNumber++;
				}
				else if(astInfo.argument[2].astType.equals(ASTtype.STRING))
				{
					treewalkCode += getTreeWalkCodeString( currentStringArgumentNumber, currentConsArgumentNumber, astInfo  ); // "cons.valueRight"
					currentStringArgumentNumber++;
				}
				else if(astInfo.argument[2].astType.equals( ASTtype.ARRAY ) )
				{
					treewalkCode += getTreeWalkCodeArray(currentStringArgumentNumber, currentConsArgumentNumber, astInfo ); // "cons.r","rArraySize"
					currentConsArgumentNumber++;
				}
	    	}
	    }
	    
		if( astInfo.isKnoopPunt() && astInfo.numberOfArguments>0)
		{
			treewalkCode += "\t\tSystem.out.print(\")\");\n";
		}
		
		if(astInfo.isMultiArray())
		{
			treewalkCode += "\t\tSystem.out.print(\"]\");\n";
		}
		
		treewalkCode += "\t}\n";
		return treewalkCode;
	}
	
	static public String getTreeWalkVariableName(int p_argumentNumberStrings,int p_argumentNumberCons, ASTtype p_astType)
	{

		String[] stringVariables = { "cons.valueLeft" , "cons.valueRight",  "cons.valueTirth" };
		String[] consVariables = { "cons.l" , "cons.r", "cons.t" };
		
		String varname = "";

		switch(p_astType)
		{
			case ARRAY:
				varname=consVariables[p_argumentNumberCons];
			break;
			case CONS:
				 varname = consVariables[p_argumentNumberCons];
			break;
			case STRING:
				int stringIndex = p_argumentNumberStrings + p_argumentNumberCons;
				varname = stringVariables[stringIndex];

			break;	
		}	

		
		return varname;	
	}
	
	static public String getAddSlashFunction()
	{
		String treewalkCode ="public String addSlashes(String input)\n\t{\n";
		treewalkCode +="\t\tString result=\"\";\n";
		treewalkCode +="\t\tif(input!=null)\n\t\t{\n";
		treewalkCode +="\t\t\tresult=input.replaceAll(\"\\\\n\",\"\\\\\\\\n\");\n";
		treewalkCode +="\t\t\tresult=result.replaceAll(\"\\\\r\",\"\\\\\\\\r\");\n";
		treewalkCode +="\t\t\tresult=result.replaceAll(\"\\\\t\",\"\\\\\\\\t\");\n";
		treewalkCode +="\t\t\tresult=result.replaceAll(\"\\\\\\\"\",\"\\\\\\\\\\\"\");\n";
		treewalkCode +="\t\t}\n\t\treturn result;\n\t}\n\n";
		return treewalkCode;
	}

}


