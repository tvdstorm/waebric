module waebric::AST

data Statement =
	ifThen(Predicate pred, Statement body, value noelse)
	| ifElse(Predicate pred, Statement body, Statement elseBody)
	| each(str var, Expression exp, Statement body)
	| let(list[Assignment] bindings, list[Statement] stats)
	| block(list[Statement] stats)
	| comment(str string)
	| echo(Expression exp)
	| \echo-embedding(Embedding emb)
	| cdata(Expression exp)
	| yield()
	| markup(Markup markup)
	| \markup-stat(list[Markup] markups, Statement stat)
	| \markup-markup(list[Markup] markups, Markup markup)
	| \markup-exp(list[Markup] markups, Expression exp)
	| \markup-embedding(list[Markup] markups, Embedding embedding);

data Assignment = 
	\var-bind(str id, Expression exp)
	| \func-bind(str id, list[str] formals, Statement stat);

data Expression =
	text(str text)
	| var(str id)
	| sym(str sym)
	| num(str nat)
	| field(Expression exp, str name)
	| cat(Expression exp1, Expression exp2)
	| \list(list[Expression] exprs)
	| record(list[KeyValuePair] pairs);

data KeyValuePair = pair(str id, Expression exp);

data Embedding =
	pre(str pre, Embed embed, TextTail tail);

data TextTail = 
	post(str post) 
	| mid(str mid, Embed embed, TextTail tail);

data Embed =
	\exp-embedding(list[Markup], Expression exp)
	| \markup-embedding(list[Markup], Markup markup);

data Markup =
	call(Designator designator, Arguments args)
	| nillary(Designator); // Injection!

data Arguments = args(list[Argument] args);

data Argument = 
	attr(str id, Expression exp)
	| \value(Expression exp); // Injection!

data Designator = 
	\tag(str id, list[Attribute] attrs);

data Attribute =
	id(str val)
	| class(str val)
	| name(str val)
	| \type(str val)
	| \width-height(str width, str height)
	| height(str height);

data ModuleId = \module-id(list[str] ids);

data Import = \import(ModuleId id);

data ModuleElement = // these are injections
	\func-def(FunctionDef def)
	| \import-decl(Import imp)
	| site(Site site);

data Module = \module(ModuleId id, list[ModuleElement] body);

data Site = site(list[Mapping] mappings);

data Mapping = mapping(Path path, Markup markup);

data Path = path(str directory, str fileName)
	| filename(str filename); // is injection


data Formals = formals(list[str] ids) | empty();

data FunctionDef = def(str id, Formals formals, list[Statement] stats); 

data Type = \list-type() | \record-type() | \string-type();

data Predicate =
	exp(Expression exp) // injection
	| \is-a(Expression exp, Type \type)
	| not(Predicate pred) 
	| and(Predicate left, Predicate right)
	| or(Predicate left, Predicate right);


private Module example = 
  \module(\module-id(["menus"]),[
site(site([mapping(filename("menus.html"),call(\tag("main",[]),args([])))])),
\func-def(def("main",empty(),[\markup-stat([call(\tag("layout",[]),args([\value(text("\"Recursive Menus\""))]))],block([
markup(call(\tag("the-menu",[]),args([])))]))])),\func-def(def("css",formals(["url","media"]),[markup(
call(\tag("link",[]),args([attr("rel",text("\"stylesheet\"")),attr("href",var("url")),
attr("type",text("\"text/css\"")),attr("media",var("media"))])))])),
\func-def(def("layout",formals(["title"]),[\markup-stat([nillary(\tag("html",[]))],block([\markup-stat(
[nillary(\tag("head",[]))],block([markup(call(\tag("css",[]),args([\value(text("\"blueprint.css\"")),
\value(text("\"screen, projection\""))]))),\markup-exp([nillary(\tag("title",[]))],var("title"))])),
\markup-stat([nillary(\tag("body",[]))],yield())]))])),\func-def(def("the-menu",empty(),[markup(call(\tag("menu",[]),
args([\value(record([pair("title",text("\"Menu\"")),pair("kids",\list([record([pair("title",text("\"Home\"")),
pair("link",text("\"/\""))]),record([pair("title",text("\"Misc\"")),pair("kids",
\list([record([pair("title",text("\"Contact\"")),pair("link",text("\"contact.html\""))]),
record([pair("title",text("\"Links\"")),pair("link",text("\"links.html\""))])]))])]))]))])))])),
\func-def(def("menu",formals(["menu"]),[echo(field(var("menu"),"title")),\markup-stat([nillary(\tag("ul",[]))],
each("kid",field(var("menu"),"kids"),markup(call(\tag("item",[]),args([\value(var("kid"))])))))])),
\func-def(def("item",formals(["mi"]),[\markup-stat([nillary(\tag("li",[]))],ifElse(exp(field(var("mi"),"kids")),
markup(call(\tag("menu",[]),args([\value(var("mi"))]))),\markup-exp([call(\tag("a",[]),args([attr("href",
field(var("mi"),"link"))]))],field(var("mi"),"title"))))]))]);
