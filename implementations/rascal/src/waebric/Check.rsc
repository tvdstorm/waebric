module waebric::Check

import waebric::AST;
import waebric::PosInfo;
import waebric::XHTML;
import List;
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
rel[ASTLoc, str, int] useArity = {};
rel[str, ASTLoc] mapping = {};
rel[ASTLoc, str] attributes = {};
rel[str, str] calls = {};
map[str, int] statistics = ();

public Module CheckEXAMPLE = waebric::AST::example;

void init() {
  arity = {};
  use = {};
  define = {};
  useArity = {};
  mapping = {};
  attributes = {};
  calls = {};
  statistics = ();
}

void printSummary() {
  println("arity = <arity>");
  println("use = <use>");
  println("define = <define>");
  println("useArity = <useArity>");
  println("mapping = <mapping>");
  println("attributes = <attributes>");
  println("calls = <calls>");
  println("statistics = <statistics>");
}



public void incStats(str label) {
  statistics[label] ?= 0;
  statistics[label] += 1;
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
     }
     case f:def(str id, empty(), list[Statement] stats): { 
         currentFunction = id; 
	 arity += {<id, 0>};
	 define += {<id, f@position>};
     }
     case c:call(\tag(str id, list[Attribute] attrs), args(list[Argument] args)) : {
         use += {<id, c@position>};
         useArity += {<c@position, id, size(args)>};
         calls += {<currentFunction, id>};
         addAttrs(c@position, attrs, args);
     }
     case c:nillary(\tag(str id, list[Attribute] attrs)): {
         use += {<id, c@position>};
         useArity += {<c@position, id, 0>};
         addAttrs(c@position, attrs);
     }
  }
  printSummary();
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



