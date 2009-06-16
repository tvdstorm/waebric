package waebric.node;

Module ::= 
	ModuleId ModuleElement*

ModuleId ::= 
	String*:id 

Mapping ::= 
	Path Markup

Path ::= 
	"String":dir "String":filename

ModuleElement ::= 
	{Site} Mapping*:m |
	{ImportDeclaration} ModuleId:id |
	{Def} "String":id Formal* Statement*

Embed ::=
	{ExpEmbedding} MarkupList:ml Expression:e |
	{MarkupEmbedding} MarkupList:ml Markup:m


Texttail ::=
	{Post} String:text |
	{Mid} String:text Embed:e Texttail:t 	
	
Embedding ::=
	Embedding | /* Hack */
	{Pre} String:text Embed:e Texttail:t	

Statement ::= 
	{Opmaak} Markup:m |
	{MarkupMarkup} MarkupList:ml Markup:m | 
	{MarkupStat} MarkupList:ml Statement:s |
	{MarkupExp} MarkupList:ml Expression:e |
	{CData} Expression:e |
	{Echo} Expression:e |
	{EchoEmbedding} Embedding:e |
	{Yield} |
	{Comment} "String":id |
	{StatementList} |
	{Let} Assignment*:ap Statement*:as |
	{Each} "String":id Expression:e Statement:s |  
	{Iff} Predicate:p Statement:s |
	{IfElse} Predicate:p Statement:s1 Statement:s2 |
	{MarkupEmbeddingg} MarkupList:ml Embedding:e | 
	MarkupList Statement |
	{Block} Statement*

Tiepe ::=
	{ListType} |
	{RecordType} |
	{StringType}
	
Predicate ::=
	Expression:e |
	{IsA} Expression:e Tiepe:t |
	{Not} Predicate:p |
	{And} Predicate:p1 Predicate:p2 |
	{Or} Predicate:p1 Predicate:p2

Assignment ::=
	{VarBind} "String":id Expression:e |
	{FuncBind} "String":id FormalList:fl Statement:s

Keyvaluepair ::=
	"String":id Expression:e
	
Expression ::=
	{List} Expression* | 
	{Var} "String":id |
	{Symb} "String":id |
	{Num} "String":id | 
	{Text} "String":id |
	{Record} Keyvaluepair* |
	{Field} Expression String

MarkupList ::= 
	Markup*

Markup ::= 
	Designator |
    {Call} Designator:d Args:args
                
Formal ::= 
	"String":idcon | 
	{Empty} /* leeg */

Designator ::=  
	Dummy |
	{Tag} "String":id Attribuut*

Dummy ::=
	{Empty}
	  
Attribuut ::=
	{Id} "String":idCon |
	{Classs} "String":idCon |
	{Name} "String":idCon |
	{Type} "String":idCon |
	{WidthHeight} "Integer":w "Integer":h |
	{Height} "Integer":num

Args ::= Argument*

Argument ::=
	Expression:e | 
	{Attri} "String":id Expression:expr	