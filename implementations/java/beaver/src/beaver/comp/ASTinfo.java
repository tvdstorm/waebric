package beaver.comp;

// Author: Allard Dijk
import beaver.comp.ASTargument;

public class ASTinfo
{
	
	public boolean bStringArray;
	public boolean bFoundCons;
	public String className;
	public String ASTname;
	public String newFuncion;
	public ASTargument argument[];
	public int numberOfArguments;
	public String stringBoolean;
	
	private boolean m_KnoopPunt;
	
	public ASTinfo(String ruleCode)
	{
		//deze class zal de benodigde informatie moeten extracten zodat anderen deze kunnen gebruiken
		int position=ruleCode.indexOf("//@");
		if(position>=0)
		{
			m_KnoopPunt=true;	
		}
		else
		{
			position=ruleCode.indexOf("//#");
			m_KnoopPunt=false;	
		}
		newFuncion= ruleCode.substring(position+3);
		//Make Classname compatible
		
		ASTname=newFuncion;
		newFuncion= newFuncion.substring(0,1).toUpperCase()  		
			+ newFuncion.substring(1).toLowerCase(); 
		
		newFuncion = newFuncion.replaceAll("-","_");
	    
		int positionLparen = newFuncion.indexOf('(');
		ASTname = ASTname.substring(0,positionLparen);
							
		int positionRparen = newFuncion.indexOf(')');
		String argumentList = newFuncion.substring(
			positionLparen+1,
			positionRparen);
	
		String argumentText[]=argumentList.split(",");
		if(argumentList.length()==0)
		{
			numberOfArguments = 0;
		}
		else
		{
			numberOfArguments = argumentText.length;
			argument = new ASTargument[numberOfArguments];
			if(argument==null)
			{
				System.out.println("ERROR: creating argument");
				return;	
			}
		}

			

		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{
			argument[argumentIndex] = new ASTargument();
			if(argument[argumentIndex]==null)
			{
				System.out.println("ERROR: creating ASTargument[]");
				return;	
			}
		}
		
		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{
			argument[argumentIndex].rawSyntax=argumentText[argumentIndex];
		}
		
		

		
		bFoundCons=true;
		if(numberOfArguments==1 && argumentText[0].indexOf("#")>=0)
		{
			bFoundCons=false;	
		}
		if(numberOfArguments==2 && 
			argumentText[0].indexOf("#")>=0 &&
			argumentText[1].indexOf("#")>=0 )
		{
			bFoundCons=false;	
		}
	
	


	 
	 
		stringBoolean = "\t\tthis.isString=false;\n"; //constructor

		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{
			if(argument[argumentIndex]==null)
			{
				System.out.println("ERROR: ASTargument[]==null");
				return;	
			}
			if(argument[argumentIndex].astType==null)
			{
				System.out.println("ERROR: astType==null");
				return;	
			}
			
			argument[argumentIndex].astType=ASTtype.CONS; //default type
					
			if(argumentText[argumentIndex].indexOf("[")==-1 &&
			   argumentText[argumentIndex].indexOf("#")>=0 && 
			   argumentText[argumentIndex].indexOf("]")==-1 &&
			   numberOfArguments<=2)
			{
				stringBoolean = "\t\tthis.isString=true;\n";
			}	
			
			if(argumentText[argumentIndex].indexOf("[")==-1 &&
			   argumentText[argumentIndex].indexOf("#")>=0 &&
			   argumentText[argumentIndex].indexOf("]")==-1 )
			{
				argument[argumentIndex].astType=ASTtype.STRING;

			}	
			
			if(argumentText[argumentIndex].indexOf("[")>=0 && 
				argumentText[argumentIndex].indexOf("#")>=0 &&
				argumentText[argumentIndex].indexOf("]")>=0)
			{
				bStringArray=true;
			}
			
			if(argumentText[argumentIndex].indexOf("[")>=0 && 
				argumentText[argumentIndex].indexOf("#")==-1 &&
				argumentText[argumentIndex].indexOf("]")>=0)
			{
				argument[argumentIndex].astType=ASTtype.ARRAY; //default type
			}
		}
		
		//extract alias
		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{
			 argument[argumentIndex].alias = argumentText[argumentIndex].replaceAll("#","");
             argument[argumentIndex].alias = argument[argumentIndex].alias.replaceAll("\\[","");
             argument[argumentIndex].alias = argument[argumentIndex].alias.replaceAll("\\]","");
		}
		className = newFuncion.substring(0,positionLparen);
		newFuncion = newFuncion.replaceAll("#","");
		newFuncion = newFuncion.replaceAll("\\[","");
		newFuncion = newFuncion.replaceAll("\\]","");
	}
	
	public void printArguments()
	{
		System.out.print("Found "+ numberOfArguments +" arguments (") ;
		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{	
					System.out.print(argument[argumentIndex].rawSyntax);
					if(argumentIndex<(numberOfArguments-1))
					{
						System.out.print(","); 
					}
		}
		System.out.print(")\n");
	}
	
	public String getBeaverType(String alias)
	{
		String result="";
		int argumentNumber = AliasToArgumentNumber(alias);
		if(argumentNumber>=0 && argumentNumber<numberOfArguments)
		{
			ASTtype astType = argument[argumentNumber].astType;
			switch(astType)
			{
				case ARRAY:
					result="ArrayList";
				break;
				case CONS:
					result="Cons";
				break;
				case STRING:
					result="String";
				break;	
			}	
		}
		else
		{
			//Error
			System.out.println("ERROR: getBeaverType() result==-1 for alias:" + alias);	
		}
		return result;
	}
	
	
	public int AliasToArgumentNumber(String alias)
	{
		int result = -1; //error value;
		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{
			if(argument[argumentIndex].alias.equals(alias))
			{
				result=argumentIndex;
				break;	
			}
		}
		if(result==-1)
		{
			System.out.println("ERROR: AliasToArgumentNumber() result==-1 for alias:" + alias);	
		}
		return result;
	}
	
	public boolean isKnoopPunt()
	{
		return m_KnoopPunt;
	}

	public int getNumberOfCons()
	{
		int nrCons=numberOfArguments;
		for (int argumentIndex=0;argumentIndex<numberOfArguments;argumentIndex++)
		{	
			if(argument[argumentIndex].astType.equals(ASTtype.STRING))
			{
				nrCons--;
			}
			
		}
		return nrCons;
	}
	
}