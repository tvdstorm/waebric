# An informal explanation of priorities in SDF #


Consider the following priority in a familiar expression language:

```
Exp "*" Exp -> Exp {left}
>
Exp "+" Exp -> Exp {left}
```


This reads that multiplication binds stronger (hence ">") than addition. Another way of looking at this is, is to consider this at the level of the generated parse trees: the priority states trees derived using the "+" rule may never be **direct** children of trees generated using the "`*`" rule. Note that this works because the "`*`" rule has Exp arguments on the left, and the "+" rule produces an Exp.

This priority mechanism works _transitively_. If, additionally, the following declaration had been present:
```
"-" Exp     -> Exp 
>
Exp "*" Exp -> Exp {left}
```
this would imply that both "`*`" and "+" cannot be direct children of "-". E.g. you cannot parse "- x `*` x" or "- x + x" as "- (x `*` x)" and "- (x + x)" respectively.


NB: the left attribute states that "x `*` x `*` x" is parsed as "(x `*` x) `*` x". In other words, the "`*`" rule may not be itself a direct child of its right argument: "x `*` (x `*` x)" is an invalid parse.

Prioritity relations can also be encoded in the grammar rules themsevles, in grammar formalisms that do not feature the mechanisms present in SDF. For the example, it could work as follows (using SDF notation):


```
Exp "+" Term    -> Exp
Term            -> Exp
Term "*" Factor -> Term
Factor          -> Term
```

Note how the rules explicitly ensure correct binding strength and associativity. Here, Factor is non-terminal capturing integer, string literals etc. Often it also includes bracketed expressions:

```
"(" Exp ")" -> Factor
```