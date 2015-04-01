# Introduction #

This assumes you have installed the Meta-Environment and that its bin directory is added to the PATH environment variable.

To generate ASTs for Waebric code using the Meta-Environment, proceed as follows. Dump the parsetable for module languages/waebric/syntax/Waebric to a file named waebric.trm.tbl.

Then from the commandline you do:
```
sglr -p waebric.trm.tbl -i <WAEBRICPROGRAM> | implodePT | trmcat > <ASTFILE>
```


For instance, the following program:
```
module test

 def main 
  html { 
   head title "Hello";
    body p "Hello";
  }
end
```

Gives the following AST:
```
module(module-id(["test"]), [def("main", empty, [markup-stat([tag("html", [])], block([markup-exp([tag("head", []), tag("title", [])], text("\"Hello\"")), markup-exp([tag("body", []), tag("p", [])], text("\"Hello\""))]))])])
```