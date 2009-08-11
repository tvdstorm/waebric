/* Generated code by OMeta's Base Javascript Translator */

{WaebricOMetaParser=Parser.delegated({"Module":function(){var $elf=this,moduleId,moduleElements;return (function(){$elf._applyWithArgs("token","module");$elf._apply("spaces");moduleId=$elf._apply("ModuleId");$elf._apply("spaces");moduleElements=$elf._many(function(){return $elf._apply("ModuleElement")});$elf._apply("spaces");$elf._apply("end");return new Module(moduleId,moduleElements)})()},"ModuleId":function(){var $elf=this,moduleId;return (function(){moduleId=$elf._applyWithArgs("listOf","IdCon",".");return new ModuleId(moduleId.join("."))})()},"ModuleElement":function(){var $elf=this;return $elf._or((function(){return $elf._apply("Site")}),(function(){return $elf._apply("FunctionDef")}),(function(){return $elf._apply("Import")}))},"Import":function(){var $elf=this,moduleId;return (function(){$elf._applyWithArgs("token","import");moduleId=$elf._apply("ModuleId");return new Import(moduleId)})()},"Site":function(){var $elf=this,mappings;return (function(){$elf._applyWithArgs("token","site");mappings=$elf._applyWithArgs("listOf","Mapping",";");$elf._applyWithArgs("token","end");return new Site(mappings)})()},"Mapping":function(){var $elf=this,path,markup;return (function(){$elf._apply("spaces");path=$elf._apply("Path");$elf._apply("spaces");$elf._applyWithArgs("token",":");$elf._apply("spaces");markup=$elf._apply("Markup");$elf._apply("spaces");return new Mapping(path,markup)})()},"Path":function(){var $elf=this,dir,file,file;return $elf._or((function(){return (function(){dir=$elf._apply("Directory");file=$elf._apply("FileName");return new Path(dir.toString().substring((0),(dir["length"] - (1))),file)})()}),(function(){return (function(){file=$elf._apply("FileName");return file})()}))},"Directory":function(){var $elf=this,pathElement;return (function(){pathElement=$elf._many1(function(){return $elf._apply("PathElement")});return pathElement.join("")})()},"PathElement":function(){var $elf=this,elem,sep;return (function(){elem=$elf._many1(function(){return $elf._apply("PathChar")});sep=$elf._applyWithArgs("token","/");return elem.join("").concat(sep)})()},"PathChar":function(){var $elf=this;return $elf._or((function(){return $elf._applyWithArgs("cRange","!","-")}),(function(){return $elf._applyWithArgs("cRange","0","[")}),(function(){return $elf._applyWithArgs("cRange","]","~")}))},"FileName":function(){var $elf=this,fileChar,fileExt;return (function(){fileChar=$elf._many1(function(){return $elf._apply("FileChar")});$elf._applyWithArgs("exactly",".");fileExt=$elf._apply("FileExt");$elf._apply("spaces");return fileChar.join("").concat(".").concat(fileExt.join(""))})()},"FileChar":function(){var $elf=this;return $elf._apply("PathChar")},"FileExt":function(){var $elf=this;return $elf._many1(function(){return $elf._apply("letterOrDigit")})},"Markup":function(){var $elf=this,designator,arguments,tag;return $elf._or((function(){return (function(){$elf._apply("spaces");designator=$elf._apply("Designator");arguments=$elf._apply("Arguments");$elf._apply("spaces");return new MarkupCall(designator,arguments)})()}),(function(){return (function(){$elf._apply("spaces");tag=$elf._apply("Designator");$elf._apply("spaces");return tag})()}))},"Designator":function(){var $elf=this,identifier,attributes;return (function(){identifier=$elf._apply("IdCon");attributes=$elf._many(function(){return $elf._apply("Attribute")});$elf._not(function(){return $elf._applyWithArgs("token","+")});return new DesignatorTag(identifier,attributes)})()},"Attribute":function(){var $elf=this,idCon,idClass,idName,idType,width,height,width;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","#");$elf._apply("spaces");idCon=$elf._apply("IdCon");return new IdAttribute(idCon)})()}),(function(){return (function(){$elf._applyWithArgs("token",".");$elf._apply("spaces");idClass=$elf._apply("IdCon");return new ClassAttribute(idClass)})()}),(function(){return (function(){$elf._applyWithArgs("token","$");$elf._apply("spaces");idName=$elf._apply("IdCon");return new NameAttribute(idName)})()}),(function(){return (function(){$elf._applyWithArgs("token",":");$elf._apply("spaces");idType=$elf._apply("IdCon");return new TypeAttribute(idType)})()}),(function(){return (function(){$elf._applyWithArgs("token","@");$elf._apply("spaces");width=$elf._apply("NatCon");$elf._apply("spaces");$elf._applyWithArgs("token","%");$elf._apply("spaces");height=$elf._apply("NatCon");return new WidthHeightAttribute(width,height)})()}),(function(){return (function(){$elf._applyWithArgs("token","@");$elf._apply("spaces");width=$elf._apply("NatCon");return new WidthAttribute(width)})()}))},"Arguments":function(){var $elf=this,args;return (function(){$elf._applyWithArgs("token","(");args=$elf._applyWithArgs("listOf","Argument",",");$elf._applyWithArgs("token",")");return args})()},"Argument":function(){var $elf=this,variable,expression,expr;return $elf._or((function(){return (function(){$elf._apply("spaces");variable=$elf._apply("IdCon");$elf._apply("spaces");$elf._applyWithArgs("token","=");$elf._apply("spaces");expression=$elf._apply("Expression");return new Argument(variable,expression)})()}),(function(){return (function(){$elf._apply("spaces");expr=$elf._apply("Expression");return expr})()}))},"FunctionDef":function(){var $elf=this,functionName,formals,statements,functionName,statements;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","def");$elf._apply("spaces");functionName=$elf._apply("IdCon");$elf._apply("spaces");formals=$elf._apply("Formals");$elf._apply("spaces");statements=$elf._many(function(){return $elf._apply("Statement")});$elf._apply("spaces");$elf._applyWithArgs("token","end");return new FunctionDefinition(functionName,formals,statements)})()}),(function(){return (function(){$elf._applyWithArgs("token","def");$elf._apply("spaces");functionName=$elf._apply("IdCon");$elf._apply("spaces");statements=$elf._many(function(){return $elf._apply("Statement")});$elf._apply("spaces");$elf._applyWithArgs("token","end");return new FunctionDefinition(functionName,[],statements)})()}))},"Formals":function(){var $elf=this,formals;return (function(){$elf._applyWithArgs("token","(");formals=$elf._applyWithArgs("listOf","IdCon",",");$elf._applyWithArgs("token",")");return formals})()},"Expression":function(){var $elf=this,expression,field,expressionLeft,expressionRight,idText,idCon,idNatCon,idSymbolCon,list,records;return $elf._or((function(){return (function(){$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",".");$elf._apply("spaces");field=$elf._apply("IdCon");$elf._not(function(){return $elf._applyWithArgs("token","?")});return new FieldExpression(expression,field)})()}),(function(){return (function(){$elf._apply("spaces");expressionLeft=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token","+");$elf._apply("spaces");expressionRight=$elf._apply("Expression");$elf._not(function(){return $elf._applyWithArgs("token","?")});return new CatExpression(expressionLeft,expressionRight)})()}),(function(){return (function(){$elf._apply("spaces");idText=$elf._apply("Text");$elf._apply("spaces");return new TextExpression(idText)})()}),(function(){return (function(){$elf._apply("spaces");idCon=$elf._apply("IdCon");$elf._apply("spaces");return new VarExpression(idCon)})()}),(function(){return (function(){$elf._apply("spaces");idNatCon=$elf._apply("NatCon");$elf._apply("spaces");return new NatExpression(idNatCon)})()}),(function(){return (function(){$elf._apply("spaces");idSymbolCon=$elf._apply("SymbolCon");$elf._apply("spaces");return new SymbolExpression(idSymbolCon)})()}),(function(){return (function(){$elf._apply("spaces");$elf._applyWithArgs("token","[");list=$elf._applyWithArgs("listOf","Expression",",");$elf._applyWithArgs("token","]");return new ListExpression(list)})()}),(function(){return (function(){$elf._apply("spaces");$elf._applyWithArgs("token","{");records=$elf._applyWithArgs("listOf","KeyValuePair",",");$elf._applyWithArgs("token","}");return new RecordExpression(records)})()}))},"KeyValuePair":function(){var $elf=this,key,value;return (function(){$elf._apply("spaces");key=$elf._apply("IdCon");$elf._apply("spaces");$elf._applyWithArgs("token",":");value=$elf._apply("Expression");return new KeyValuePair(key,value)})()},"Statement":function(){var $elf=this,predicate,ifStatement,predicate,ifStatement,elseStatement,identifier,expression,statement,assignments,statements,statements,comment,expression,embedding,expression,markup,markups,markups,markups,markups,expression,markups,statement,markups,embedding;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","if");$elf._apply("spaces");$elf._applyWithArgs("token","(");$elf._apply("spaces");predicate=$elf._apply("Predicate");$elf._apply("spaces");$elf._applyWithArgs("token",")");$elf._apply("spaces");ifStatement=$elf._apply("Statement");$elf._apply("NoElseMayFollow");return new IfStatement(predicate,ifStatement)})()}),(function(){return (function(){$elf._applyWithArgs("token","if");$elf._apply("spaces");$elf._applyWithArgs("token","(");$elf._apply("spaces");predicate=$elf._apply("Predicate");$elf._apply("spaces");$elf._applyWithArgs("token",")");$elf._apply("spaces");ifStatement=$elf._apply("Statement");$elf._apply("spaces");$elf._applyWithArgs("token","else");$elf._apply("spaces");elseStatement=$elf._apply("Statement");return new IfElseStatement(predicate,ifStatement,elseStatement)})()}),(function(){return (function(){$elf._applyWithArgs("token","each");$elf._apply("spaces");$elf._applyWithArgs("token","(");$elf._apply("spaces");identifier=$elf._apply("IdCon");$elf._apply("spaces");$elf._applyWithArgs("token",":");$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",")");$elf._apply("spaces");statement=$elf._apply("Statement");return new EachStatement(identifier,expression,statement)})()}),(function(){return (function(){$elf._applyWithArgs("token","let");assignments=$elf._many1(function(){return $elf._apply("Assignment")});$elf._applyWithArgs("token","in");statements=$elf._many(function(){return $elf._apply("Statement")});$elf._applyWithArgs("token","end");return new LetStatement(assignments,statements)})()}),(function(){return (function(){$elf._applyWithArgs("token","{");$elf._apply("spaces");statements=$elf._many(function(){return $elf._apply("Statement")});$elf._apply("spaces");$elf._applyWithArgs("token","}");return new BlockStatement(statements)})()}),(function(){return (function(){$elf._applyWithArgs("token","comment");$elf._apply("spaces");comment=$elf._apply("StrCon");$elf._apply("spaces");$elf._applyWithArgs("token",";");return new CommentStatement(comment)})()}),(function(){return (function(){$elf._applyWithArgs("token","echo");$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",";");return new EchoStatement(expression)})()}),(function(){return (function(){$elf._applyWithArgs("token","echo");$elf._apply("spaces");embedding=$elf._apply("Embedding");$elf._apply("spaces");$elf._applyWithArgs("token",";");return new EchoEmbeddingStatement(embedding)})()}),(function(){return (function(){$elf._applyWithArgs("token","cdata");$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",";");return new CDataExpression(expression)})()}),(function(){return (function(){$elf._applyWithArgs("token","yield");$elf._applyWithArgs("token",";");return new YieldStatement()})()}),(function(){return (function(){markup=$elf._apply("Markup");$elf._applyWithArgs("token",";");return new MarkupStatement(markup)})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");$elf._applyWithArgs("token",";");$elf._apply("spaces");$elf._pred(((markups[(markups["length"] - (1))] instanceof DesignatorTag) && (!containsClassAttribute(markups[(markups["length"] - (1))]))));return new MarkupExpressionStatement(markups.slice((0),(markups["length"] - (1))),new VarExpression(markups[(markups["length"] - (1))]["idCon"]))})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");$elf._applyWithArgs("token",";");$elf._apply("spaces");$elf._pred(((markups[(markups["length"] - (1))] instanceof DesignatorTag) && containsClassAttribute(markups[(markups["length"] - (1))])));return new MarkupExpressionStatement(markups.slice((0),(markups["length"] - (1))),convertToFieldExpression(markups[(markups["length"] - (1))]))})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");$elf._applyWithArgs("token",";");$elf._apply("spaces");$elf._pred((markups["length"] > (1)));return new MarkupMarkupStatement(markups)})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",";");$elf._apply("spaces");return new MarkupExpressionStatement(markups,expression)})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");statement=$elf._apply("Statement");return new MarkupStatementStatement(markups,statement)})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._apply("spaces");embedding=$elf._apply("Embedding");$elf._apply("spaces");$elf._applyWithArgs("token",";");return new MarkupEmbeddingStatement(markups,embedding)})()}))},"NoElseMayFollow":function(){var $elf=this;return $elf._not(function(){return $elf._applyWithArgs("token","else")})},"Predicate":function(){var $elf=this,predicate,predicateLeft,predicateRight,predicateLeft,predicateRight,expression,type;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","!");$elf._apply("spaces");predicate=$elf._apply("Predicate");$elf._apply("spaces");return new NotPredicate(predicate)})()}),(function(){return (function(){predicateLeft=$elf._apply("Predicate");$elf._apply("spaces");$elf._applyWithArgs("token","&&");$elf._apply("spaces");predicateRight=$elf._apply("Predicate");$elf._apply("spaces");return new AndPredicate(predicateLeft,predicateRight)})()}),(function(){return (function(){predicateLeft=$elf._apply("Predicate");$elf._apply("spaces");$elf._applyWithArgs("token","||");$elf._apply("spaces");predicateRight=$elf._apply("Predicate");$elf._apply("spaces");return new OrPredicate(predicateLeft,predicateRight)})()}),(function(){return (function(){expression=$elf._apply("Expression");$elf._applyWithArgs("token",".");type=$elf._apply("Type");$elf._applyWithArgs("token","?");return new IsAPredicate(expression,type)})()}),(function(){return $elf._apply("Expression")}))},"Type":function(){var $elf=this;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","list");return new ListType()})()}),(function(){return (function(){$elf._applyWithArgs("token","record");return new RecordType()})()}),(function(){return (function(){$elf._applyWithArgs("token","string");return new StringType()})()}))},"Assignment":function(){var $elf=this,variable,expression,variable,formals,statement;return $elf._or((function(){return (function(){$elf._apply("spaces");variable=$elf._apply("IdCon");$elf._apply("spaces");$elf._applyWithArgs("token","=");$elf._apply("spaces");expression=$elf._apply("Expression");$elf._apply("spaces");$elf._applyWithArgs("token",";");$elf._apply("spaces");return new VariableBinding(variable,expression)})()}),(function(){return (function(){variable=$elf._apply("IdCon");$elf._apply("spaces");formals=$elf._apply("Formals");$elf._apply("spaces");$elf._applyWithArgs("token","=");$elf._apply("spaces");statement=$elf._apply("Statement");return new FunctionBinding(variable,formals,statement)})()}))},"TextEntityRef":function(){var $elf=this;return (function(){$elf._applyWithArgs("token","&");$elf._apply("TextEntityRefHead");$elf._many(function(){return $elf._apply("TextEntityRefTail")});return $elf._applyWithArgs("token",";")})()},"TextEntityRefHead":function(){var $elf=this;return $elf._or((function(){return $elf._apply("letter")}),(function(){return $elf._applyWithArgs("token","_")}),(function(){return $elf._applyWithArgs("token",":")}))},"TextEntityRefTail":function(){var $elf=this;return $elf._or((function(){return $elf._apply("letterOrDigit")}),(function(){return $elf._applyWithArgs("token",".")}),(function(){return $elf._applyWithArgs("token","-")}),(function(){return $elf._applyWithArgs("token","_")}),(function(){return $elf._applyWithArgs("token",":")}))},"Text":function(){var $elf=this,idText;return (function(){$elf._applyWithArgs("exactly","\"");idText=$elf._many(function(){return $elf._or((function(){return $elf._apply("EscQuote")}),(function(){return (function(){$elf._not(function(){return $elf._applyWithArgs("exactly","\"")});return $elf._apply("TextChar")})()}))});$elf._applyWithArgs("exactly","\"");return idText.join("")})()},"TextChar":function(){var $elf=this;return $elf._or((function(){return $elf._apply("TextSymbolChar")}),(function(){return $elf._apply("Amp")}),(function(){return $elf._apply("TextCharRef")}),(function(){return $elf._apply("TextEntityRef")}),(function(){return $elf._apply("space")}))},"TextSymbolChar":function(){var $elf=this;return $elf._or((function(){return $elf._applyWithArgs("exactly","!")}),(function(){return $elf._applyWithArgs("cRange","#","%")}),(function(){return $elf._applyWithArgs("cRange","\'",";")}),(function(){return $elf._applyWithArgs("cRange","=","~")}),(function(){return $elf._apply("space")}))},"TextCharRef":function(){var $elf=this;return $elf._or((function(){return (function(){$elf._applyWithArgs("token","&#");$elf._many1(function(){return $elf._apply("digit")});return $elf._applyWithArgs("token",";")})()}),(function(){return (function(){$elf._applyWithArgs("token","&#x");$elf._many1(function(){return $elf._apply("HexaDecimal")});return $elf._applyWithArgs("token",";")})()}))},"Embedding":function(){var $elf=this,head,embed,tail;return (function(){$elf._apply("spaces");head=$elf._apply("PreText");$elf._apply("spaces");embed=$elf._apply("Embed");$elf._apply("spaces");tail=$elf._apply("TextTail");$elf._apply("spaces");return new Embedding(head,embed,tail)})()},"Embed":function(){var $elf=this,markups,expression,markups,markups,markups;return $elf._or((function(){return (function(){markups=$elf._many(function(){return $elf._apply("Markup")});$elf._apply("spaces");expression=$elf._apply("Expression");return new ExpressionEmbedding(markups,expression)})()}),(function(){return (function(){markups=$elf._many(function(){return $elf._apply("Markup")});$elf._pred(((markups[(markups["length"] - (1))] instanceof DesignatorTag) && (!containsClassAttribute(markups[(markups["length"] - (1))]))));return new ExpressionEmbedding(markups.slice((0),(markups["length"] - (1))),new VarExpression(markups[(markups["length"] - (1))]["idCon"]))})()}),(function(){return (function(){markups=$elf._many1(function(){return $elf._apply("Markup")});$elf._pred(((markups[(markups["length"] - (1))] instanceof DesignatorTag) && containsClassAttribute(markups[(markups["length"] - (1))])));return new MarkupExpressionStatement(markups.slice((0),(markups["length"] - (1))),convertToFieldExpression(markups[(markups["length"] - (1))]))})()}),(function(){return (function(){markups=$elf._many(function(){return $elf._apply("Markup")});return new MarkupEmbedding(markups)})()}))},"PreText":function(){var $elf=this,text;return (function(){$elf._applyWithArgs("token","\"");text=$elf._many(function(){return $elf._apply("TextChar")});$elf._applyWithArgs("token","<");return text.join("")})()},"PostText":function(){var $elf=this,text;return (function(){$elf._applyWithArgs("token",">");text=$elf._many(function(){return $elf._apply("TextChar")});$elf._applyWithArgs("token","\"");return text.join("")})()},"MidText":function(){var $elf=this,text;return (function(){$elf._applyWithArgs("token",">");text=$elf._many(function(){return $elf._apply("TextChar")});$elf._applyWithArgs("token","<");return text.join("")})()},"TextTail":function(){var $elf=this,text,mid,embed,tail;return $elf._or((function(){return (function(){text=$elf._apply("PostText");return new PostTextTail(text)})()}),(function(){return (function(){mid=$elf._apply("MidText");embed=$elf._apply("Embed");tail=$elf._apply("TextTail");return new MidTextTail(mid,embed,tail)})()}))},"IdCon":function(){var $elf=this,head,tail;return (function(){$elf._apply("spaces");head=$elf._apply("IdCharHead");tail=$elf._many(function(){return $elf._apply("IdCharTail")});$elf._apply("spaces");$elf._pred(((((((((((((((head.concat(tail.join("")) != "if") && (head.concat(tail.join("")) != "comment")) && (head.concat(tail.join("")) != "echo")) && (head.concat(tail.join("")) != "cdata")) && (head.concat(tail.join("")) != "each")) && (head.concat(tail.join("")) != "let")) && (head.concat(tail.join("")) != "yield")) && (head.concat(tail.join("")) != "module")) && (head.concat(tail.join("")) != "import")) && (head.concat(tail.join("")) != "def")) && (head.concat(tail.join("")) != "end")) && (head.concat(tail.join("")) != "site")) && (head.concat(tail.join("")) != "else")) && (head.concat(tail.join("")) != "in")));return head.concat(tail.join(""))})()},"IdCharHead":function(){var $elf=this;return $elf._apply("letter")},"IdCharTail":function(){var $elf=this;return $elf._or((function(){return $elf._apply("letterOrDigit")}),(function(){return $elf._applyWithArgs("exactly","-")}))},"NatCon":function(){var $elf=this,d;return (function(){d=$elf._many1(function(){return $elf._apply("digit")});return d.join("")})()},"SymbolCon":function(){var $elf=this,prefix,idSymbolCon;return (function(){prefix=$elf._applyWithArgs("token","\'");idSymbolCon=$elf._many(function(){return $elf._apply("SymbolChar")});return prefix.concat(idSymbolCon.join(""))})()},"SymbolChar":function(){var $elf=this;return $elf._or((function(){return $elf._applyWithArgs("cRange","!","(")}),(function(){return $elf._applyWithArgs("cRange","*","+")}),(function(){return $elf._applyWithArgs("cRange","-",":")}),(function(){return $elf._applyWithArgs("cRange","<","=")}),(function(){return $elf._applyWithArgs("cRange","?","\\")}),(function(){return $elf._applyWithArgs("cRange","^","|")}),(function(){return $elf._applyWithArgs("exactly","~")}))},"StrCon":function(){var $elf=this,str;return (function(){$elf._applyWithArgs("token","\"");str=$elf._many(function(){return $elf._apply("StrChar")});$elf._applyWithArgs("token","\"");return str.join("")})()},"StrChar":function(){var $elf=this;return $elf._or((function(){return $elf._applyWithArgs("exactly"," ")}),(function(){return $elf._applyWithArgs("token","\\n")}),(function(){return $elf._applyWithArgs("token","\\t")}),(function(){return $elf._applyWithArgs("token","\\\"")}),(function(){return $elf._applyWithArgs("token","\\\\")}),(function(){return (function(){$elf._applyWithArgs("token","\\");$elf._apply("digit");$elf._apply("digit");return $elf._apply("digit")})()}),(function(){return $elf._applyWithArgs("exactly","!")}),(function(){return $elf._applyWithArgs("cRange","#","[")}),(function(){return $elf._applyWithArgs("cRange","]","~")}))},"HexaDecimal":function(){var $elf=this,c;return (function(){c=$elf._apply("char");return $elf._pred(((((c >= "0") && (c <= "9")) || ((c >= "A") && (c <= "F"))) || ((c >= "a") && (c <= "f"))))})()},"Amp":function(){var $elf=this;return $elf._applyWithArgs("token","&")},"Comment":function(){var $elf=this;return $elf._or((function(){return $elf._applyWithArgs("fromTo","/*","*/")}),(function(){return $elf._applyWithArgs("fromTo","//","\n")}))},"space":function(){var $elf=this;return $elf._or((function(){return Parser._superApplyWithArgs($elf,"space")}),(function(){return $elf._apply("Comment")}))},"EscQuote":function(){var $elf=this;return (function(){$elf._applyWithArgs("exactly","\\");$elf._applyWithArgs("exactly","\"");return "\\\""})()},"fromTo":function(){var $elf=this,x,y;return (function(){x=$elf._apply("anything");y=$elf._apply("anything");$elf._applyWithArgs("seq",x);$elf._many(function(){return (function(){$elf._not(function(){return $elf._applyWithArgs("seq",y)});return $elf._apply("char")})()});return $elf._applyWithArgs("seq",y)})()},"cRange":function(){var $elf=this,x,y,c;return (function(){x=$elf._apply("anything");y=$elf._apply("anything");c=$elf._apply("char");$elf._pred((c >= x));$elf._pred((c <= y));return c})()}});var convertToFieldExpression=(function (designatorTag){var fieldExpression=new VarExpression(designatorTag["idCon"]);for(var i=(0);(i < designatorTag["attributes"]["length"]);i++){var attr=designatorTag["attributes"][i];if((attr instanceof ClassAttribute)){fieldExpression=new FieldExpression(fieldExpression,attr["className"])}else{undefined}};return fieldExpression});var containsClassAttribute=(function (designatorTag){for(var i=(0);(i < designatorTag["attributes"]["length"]);i++){var attr=designatorTag["attributes"][i];if((attr instanceof ClassAttribute)){return true}else{undefined}};return false})}