module waebric::Check

import waebric::AST;
import waebric::PosInfo;
import waebric::XHTML;
import List;
import Set;
import Relation;
import IO;

/* $rstore1 := declare($rstore0, Arity, rel[str, int]),
	$rstore2 := declare($rstore1, Use, rel[str, loc]),
	$rstore3 := declare($rstore2, Define, rel[str, loc]),
	$rstore4 := declare($rstore3, UseArity, rel[loc, <str, int>]),
	$rstore5 := declare($rstore4, Mapping, rel[str, loc]),
	$rstore6 := declare($rstore5, Attributes, rel[loc, str]),
	$rstore7 := declare($rstore6, Call, rel[str,str]),
	$rstore8 := declare($rstore7, Statistics, rel[str, int])
*/

rel[str, int] arity = {};
rel[str, ASTLoc] use = {};
rel[str, ASTLoc] define = {};
rel[ASTLoc, tuple[str, int]] useArity = {};
rel[str, ASTLoc] mappings = {};
rel[ASTLoc, str] attributes = {};
rel[str, str] calls = {};
map[str, int] statistics = ();
rel[ASTLoc, str] freeVars = {}; 

public Module CheckEXAMPLE =  \module(\module-id(["menus"]),[
site(site([
mapping(filename("menus.html"),call(\tag("main",[]),args([]))),
mapping(filename("menus.html"),call(\tag("main2",[]),args([])))
])),
\func-def(def("main",empty(),[\markup-stat([call(\tag("layout",[]),args([\value(text("\"Recursive Menus\""))]))],block([
markup(call(\tag("the-menu",[]),args([])))]))])),\func-def(def("main",formals(["url","media"]),[markup(
call(\tag("link",[]),args([attr("rel",text("\"stylesheet\"")),attr("href",var("url")),
attr("type",text("\"text/css\"")),attr("media",var("media"))])))])),
\func-def(def("layout", //formals(["title"])
empty(),[\markup-stat([nillary(\tag("html",[]))],block([\markup-stat(
[nillary(\tag("head",[]))],block([markup(call(\tag("css",[]),args([\value(text("\"blueprint.css\"")),
\value(text("\"screen, projection\""))]))),\markup-exp([nillary(\tag("title",[]))],var("itle"))])),
\markup-stat([nillary(\tag("body",[]))],yield())]))])),\func-def(def("the-menu",empty(),[markup(call(\tag("menu",[]),
args([\value(record([pair("title",text("\"Menu\"")),pair("kids",\list([record([pair("title",text("\"Home\"")),
pair("link",text("\"/\""))]),record([pair("title",text("\"Misc\"")),pair("kids",
\list([record([pair("title",text("\"Contact\"")),pair("link",text("\"contact.html\""))]),
record([pair("title",text("\"Links\"")),pair("link",text("\"links.html\""))])]))])]))]))])))])),
\func-def(def("menu",formals(["menu"]),[echo(field(var("menu"),"title")),\markup-stat([nillary(\tag("ul",[]))],
each("kid",field(var("menu"),"kids"),markup(call(\tag("applet",[]),args([\value(var("kid"))])))))])),
\func-def(def("item",formals(["mi"]),[\markup-stat([nillary(\tag("li",[]))],ifElse(exp(field(var("mi"),"kids")),
markup(call(\tag("menu",[]),args([\value(var("mi"))]))),\markup-exp([call(\tag("a",[]),args([attr("href",
field(var("mi"),"link"))]))],field(var("mi"),"title"))))]))]);


void init() {
  arity = {};
  use = {};
  define = {};
  useArity = {};
  mappings = {};
  attributes = {};
  calls = {};
  statistics = ();
  freeVars = {};
}

void printSummary() {
  println("arity = <arity>");
  println("use = <use>");
  println("define = <define>");
  println("useArity = <useArity>");
  println("mappings = <mappings>");
  println("attributes = <attributes>");
  println("calls = <calls>");
  println("statistics = <statistics>");
  println("freeVars = <freeVars>");
}



public void incStats(str label) {
  statistics[label] ?= 0;
  statistics[label] += 1;
}

public set[str] freeVariables(list[Statement] stats) {
   set[str] result = {};
   for (Statement stat <- stats) {
     set[str] free = {};
     visit (stat) {
       case let(list[Assignment] bindings, list[Statement] stats):
         free -= {id | \var-bind(str id, Expression exp) <- bindings }; 
       case each(str id, Expression exp, Statement stat):
         free -= {id}; 
       case var(str id):
         free += {id};
     }
     result += free;
   }
   return result; 
}

public void summarize(Module mod) {
   init();
   mod = addPositions(mod);
   str currentFunction = "$site";
   top-down visit (mod) {
     case f:def(str id, formals(list[str] ids), list[Statement] stats): {
         currentFunction = id; 
	 arity += {<id, size(ids)>};
	 define += {<id, f@position>};
         freeVars += {f@position} * (freeVariables(stats) - {i | str i <- ids} );
     }
     case f:def(str id, empty(), list[Statement] stats): { 
         currentFunction = id; 
	 arity += {<id, 0>};
	 define += {<id, f@position>};
         freeVars += {f@position} * freeVariables(stats);
     }
     case c:call(\tag(str id, list[Attribute] attrs), args(list[Argument] args)) : {
         use += {<id, c@position>};
         useArity += {<c@position, <id, size(args)>>};
         calls += {<currentFunction, id>};
         addAttrs(c@position, attrs, args);
     }
     case c:nillary(\tag(str id, list[Attribute] attrs)): {
         use += {<id, c@position>};
         useArity += {<c@position, <id, 0>>};
         addAttrs(c@position, attrs);
     }
     case m:mapping(path(str dir, str file), Markup _): {
         mappings += {<"<dir>/<file>", m@position>};
     } 
     case m:mapping(filename(str file), Markup _): {
         mappings += {<file, m@position>};
     } 
  }
  printSummary();
}

data Error = error(str message, set[ASTLoc] locations);

public list[Error] check(Module mod) {
   list[Error] result = [];
   summarize(mod);

   // Duplicate definition errors

   names = domain(define);
   for (str name <- names) {
     if (size(domainR(define, {name})) > 1) {
        result += [error("duplicate function definition for `<name>'", define[name])];
     }
   }

   // Arity errors

   set[ASTLoc] usedAndDefined = use[names];
   rel[ASTLoc, tuple[str, int]] usedArities = domainR(useArity, usedAndDefined);
   rel[ASTLoc, tuple[str, int]] arities = rangeX(usedArities, arity);
   
   for (<ASTLoc pos, <str name, int got>> <- arities) {
     if ({int expected} := arity[name]) {
        msg = "expected <expected> parameters, got <got>; violation of `<name>'";
	result += [error(msg, {pos})];
     } 
   } 

   // Multiple file mappings

   set[str] filenames = domain(mappings);
   for (str filename <- filenames) {
      if (size(mappings[filename]) > 1) {
        result += [error("multiple mapping of filename <filename>", mappings[filename])];
      }
   }

   // "Undefined" names (e.g. undefined & not in XHTML).

   for (<str n, ASTLoc pos> <- use, n notin domain(define) + XHTML_ELEMENTS) {
      result += [error("tag `<n>' not defined in XHTML 1.0 Transitional", {pos})];
   }

   // Deprecated elements

   for (<str n, ASTLoc pos> <- use, n notin domain(define), n in XHTML_DEPRECATED) {
      result += [error("tag `<n>' deprecated in XHTML 1.0 Transitional", {pos})];
   }

   // Undefined variables
   for (ASTLoc pos <- domain(freeVars)) {
     vars = freeVars[pos];
     if (vars != {}) {
       if (str name <- invert(define)[pos]) {
         result += [error("undefined variables in `<name>': <vars>", {pos})];
       }
     }
   }
 
   return result;
}

public void addAttrs(ASTLoc pos, list[Attribute] attrs) {
  addAttrs(pos, attrs, []);
}

public void addAttrs(ASTLoc pos, list[Attribute] attrs, list[Argument] args) {
  for (Attribute attr <- attrs) {
   switch (attr) {
     case id(str val): attributes += {<pos, "id">};
     case class(str val): attributes += {<pos, "class">};
     case name(str val): attributes += {<pos, "name">};
     case \type(str val): attributes += {<pos, "type">};
     case \width-height(str width, str height): {
       attributes += {<pos, "width">};
       attributes += {<pos, "height">};
     }
     case height(str height): attributes += {<pos, "height">};
   }
  }
  for (Argument arg <- args) {
    switch (arg) {
     case attr(str id, Expression exp): attributes += {<pos, id>};
     case \value(Expression exp): attributes += {<pos, "value">};
   }
  }
}



