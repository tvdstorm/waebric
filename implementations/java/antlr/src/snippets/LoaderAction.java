
public class LoaderAction {
 public void mapping() {
	 int index = 0;
	 index = input.index();
	 mappings.add(retval);
 }
 
 public void function() {
	 int args = 0; int index = 0;
	 index = input.index();
	 args = $formals.args;
	 if($statements.yield) { yields.add($index); }
	 if(functions.containsKey($id.getText())) {
		exceptions.add(new WaebricChecker.DuplicateFunctionException($id));
	} else { functions.put($id.getText(), retval); }
 }
 
 public void formals() {
	 int args = 0;
	 args++;
 }
 
 public void statements() {
	 boolean yield = false;
	 if($s.yield) { $yield = true; }
 }
 
 public void statement() {
	 boolean yield = false;
	 if($t.yield) yield = true; 
	 if($f.yield) yield = true; 
	 yield = $stm.yield;
	 yield = $stms.yield;
	 yield = $stms.yield;
	 yield = true;
	 yield = $markupChain.yield;
 }
 
 public void markupChain() {
	 boolean yield = false;
	 yield = $c.yield;
	 yield = $s.yield;
 }
}
