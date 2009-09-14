module waebric::PosInfo

import waebric::AST;

alias ASTLoc = int;

anno ASTLoc FunctionDef @ position;
anno ASTLoc Markup @ position;

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
    };
}

