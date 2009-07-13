tree grammar Eval2;

options {
    tokenVocab=Expr2;
    ASTLabelType=CommonTree;
}

// START:members
@header {
    import java.util.Map;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.math.BigInteger;
}

@members {
    /** Functions definitions and their start in the tokenstream (for pushing them in nested calls).
     *  It's important to keep the order of the definitions, therefore we use a LinkedHashMap here.
     */
    private Map<CommonTree, Integer> functionDefinitions = new LinkedHashMap<CommonTree, Integer>();

    /** Remember local variables. Currently, this is only the function parameter.
     */
    private final Map<String, BigInteger> localMemory = new HashMap<String, BigInteger>();

    /** Remember global variables set by =. */
    private Map<String, BigInteger> globalMemory = new HashMap<String, BigInteger>();

    /** Find matching function definition for a function name and parameter
     *  value. The first definition is returned where (a) the name matches
     *  and (b) the formal parameter agrees if it is defined as constant.
     */
    private CommonTree findFunction(String name, BigInteger paramValue) {
        SEARCH:
        for (CommonTree f : functionDefinitions.keySet()) {
            // Expected tree for f: ^(FUNC ID (ID | INT) expr)
            if (f.getChild(0).getText().equals(name)) {
                // Check whether parameter matches
              	CommonTree formalPar = (CommonTree) f.getChild(1);
                if (formalPar.getToken().getType() == INT
                    && !new BigInteger(formalPar.getToken().getText()).equals(paramValue)) {
                        // Constant in formalPar list does not match actual value -> no match.
                        continue SEARCH;
                }
                // Parameter (value for INT formal arg) as well as fct name agrees!
                return f;
            }
        }
        return null;
    }

    /** Get value of name up call stack. */
    public BigInteger getValue(String name) {
        BigInteger value = localMemory.get(name);
        if ( value!=null ) {
            return value;
        }
        value = globalMemory.get(name);
        if ( value!=null ) {
            return value;
        }
        // not found in local memory or global memory
        System.err.println("undefined variable "+name);
        return BigInteger.ZERO;
    }
}
// END:members

// START:rules
prog
    :   stat+
    ;

stat:   expr                       { String result = $expr.value.toString();
                                     System.out.println($expr.value + " (about " + result.charAt(0) + "*10^" + (result.length()-1) + ")");
                                   }
    |   ^('=' ID expr)             { globalMemory.put($ID.text, $expr.value); }
    |   ^(FUNC ID . /*ID|INT*/     { functionDefinitions.put($stat.start, input.index()); }
                    . /* expr */)
    ;

expr returns [BigInteger value]
    :   ^('+' a=expr b=expr)       { $value = $a.value.add($b.value); }
    |   ^('-' a=expr b=expr)       { $value = $a.value.subtract($b.value); }
    |   ^('*' a=expr b=expr)       { $value = $a.value.multiply($b.value); }
    |   ^('/' a=expr b=expr)       { $value = $a.value.divide($b.value); }
    |   ^('%' a=expr b=expr)       { $value = $a.value.remainder($b.value); }
    |   ID                         { $value = getValue($ID.text); }
    |   INT                        { $value = new BigInteger($INT.text); }
    |   call                       { $value = $call.value; }
    ;

call returns [BigInteger value]
    :   ^(CALL ID expr)            { BigInteger p = $expr.value;
                                     CommonTree funcRoot = findFunction($ID.text, p);
                                     if (funcRoot == null) {
                                         System.err.println("No match found for " + $ID.text + "(" + p + ")");
                                     } else {
                                         // Push parameter value into local memory; and expr tree onto node stream.
                                         String paramName = funcRoot.getChild(1).getText();
                                         BigInteger prevValue = localMemory.put(paramName, p);

                                         CommonTreeNodeStream commonInput = (CommonTreeNodeStream) input;
                                         int exprStartIndex = functionDefinitions.get(funcRoot);
                                         commonInput.push(exprStartIndex);

                                         value = expr();

                                         // Restore node stream and local variable to previous values.
                                         commonInput.pop();
                                         localMemory.put(paramName, prevValue);
                                     }
                                   }
    ;
// END:rules
