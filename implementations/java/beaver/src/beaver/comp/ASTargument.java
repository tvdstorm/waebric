package beaver.comp;
// Author: Allard Dijk
enum ASTtype { 
	ARRAY,
	CONS,
	STRING
}

public class ASTargument
{
	public ASTtype astType;
	public String alias;
	public String rawSyntax;
	public boolean m_bUseQuotes;
	
	public ASTargument()
	{
		astType=ASTtype.CONS;
		alias="";
		rawSyntax="";	
	}
	
	public boolean isNode()
	{
		boolean result=false;
		switch(astType)
		{
			case CONS:
				result=true;
				break;
			case ARRAY:
				result=true;
				break;
			case STRING:
				result=false;
				break;
	
		}
		
		return result;
	}
	
	public String sGetType()
	{
		String result="";
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
			default:
				System.out.println("ERROR: ASTargument::sGetType() cant find current type");
				break;
		}	
		return result;	
	}
	
	public boolean bUseQuotes()
	{
		return m_bUseQuotes;
	}

}

