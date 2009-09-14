module waebric::PosInfo

import waebric::AST;

alias ASTLoc = int;

anno ASTLoc FunctionDef @ position;
anno ASTLoc Markup @ position;
anno ASTLoc Mapping @ position;
anno ASTLoc Expression @ position;

public Module addPositions(Module mod) {
    int n = 0;
    return visit (mod) {
      case FunctionDef f: {
         n += 1;
         insert f[@position = n];
      }
      case Markup f: {
         n += 1;
         insert f[@position = n];
      }
      case Expression e: {
         n += 1;
         insert e[@position = n];
      }
      case Mapping m: {
         n += 1;
         insert m[@position = n];
      }
    };
}

