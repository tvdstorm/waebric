/////
// complexity.js
// @2009, Noah Peters
// http://code.google.com/p/jsmeter
// version : 0.2.6
/*
// jsmeter : 
// Written by: Noah Peters
//
Copyright (c) 2008, Noah Peters
All rights reserved.
Redistribution and use in source and binary forms, with or without 
modification, are permitted provided that the following conditions 
are met:
	-	Redistributions of source code must retain the above 
	copyright notice, this list of conditions and the following 
	disclaimer.
	-	Redistributions in binary form must reproduce the above 
	copyright notice, this list of conditions and the following 
	disclaimer in the documentation and/or other materials provided 
	with the distribution.
	-	Neither the name of the <ORGANIZATION> nor the names of 
	its contributors may be used to endorse or promote products 
	derived from this software without specific prior written 
	permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
//
*/
/*jslint browser: true, evil: true */
/*global tree */
var make_complexity = function() {
    var f = null,
    
        pn = null, //previous node
        
        cn = null, //current node
        
        fns = [],
    
        itself = {},
        
        sigDig = function(value, sd) {
            if (value===0) {
                return 0;
            }
            var z = Math.ceil(Math.log(value)/Math.log(10)),
                v = Math.round(value * Math.pow(10, 0-z+sd)),
                l = (""  + v).length;
            v = v * Math.pow(10, z-sd);
            if (l-z<sd) {
                v = (""+v).substr(0,sd+1);
                if (v.indexOf(".")<0) {
                    v = v + ".";
                }
                while (v.length<sd+1) {
                    v = v + "0";
                }
            } else if (l<=sd) {
                v = (""+v).substr(0,l-z+2);
                if (v.indexOf(".")<0) {
                    v = v + ".";
                }
                while (v.length<l-z+2) {
                    v = v + "0";
                }
            }
            if (v.indexOf(".")===v.length-1) {
                v = v.replace(".", "");
            }
            return v;
        },
		
		roundNumber = function(num, dec) {
			var result = Math.round( Math.round( num * Math.pow( 10, dec + 1 ) ) / Math.pow( 10, 1 ) ) / Math.pow(10,dec);
			return result;
		}
        
        func = function(name, parent) {
        
            this.edges = 1;
            this.nodes = 2; //entry, exit
            this.exits = 1;
            this.c = 0;
            this.complexity = function() {
                return this.edges - this.nodes + this.exits + 1;
            };
            this.shortName = name || ("(Anonymous" + (parent.anons+=1) + ")");
            if (this.shortName[this.shortName.length-1]===".") {
                this.shortName = this.shortName + "(Anonymous" + (parent.anons+=1) + ")";
            }
            this.name = ((parent?(parent.name + "."):"") + this.shortName).replace("..",".");
            this.s = 0; //statements
            this.b = 0; //branches
            this.parent = parent;
            this.anons = 0; //anonymous function number
            this.depth = parent ? (parent.depth + 1) : 0;
            this.blockDepth = 0;
            this.lineStart = cn?cn.line:1;
            this.comments = 0;
            this.lineEnd = this.lineStart;
            this.operatorCount = 0;
            this.operandCount = 0;
            this.operators = { };
            this.operands = { };
            this.ins = 0;
            this.halsteadVocabulary = function() {
                var h1 = 0, h2 = 0, o;
                for (o in this.operators) {
                    if (this.operators[o]===true) {
                        h1++;
                    }
                }
                for (o in this.operands) {
                    if (this.operands[o]===true) {
                        h2++;
                    }
                }
                return h1 + h2 //+ 4;
            };
			this.uniqueOperators = function() {
                var h1 = 0;
                for (o in this.operators) {
                    if (this.operators[o]===true) {
                        h1++;
                    }
                }
                return h1;
            };
			this.uniqueOperands = function() {
                var h1 = 0;
                for (o in this.operands) {
                    if (this.operands[o]===true) {
                        h1++;
                    }
                }
                return h1;
            };
			
            this.halsteadLength = function() {
                return this.operatorCount + this.operandCount;
            };
            this.halsteadVolume = function() {
                if (this.halsteadLength() === 0) {
                    return sigDig(0, 3);
                }
				var volume = (Math.log(this.halsteadVocabulary()) / Math.log(2)) * this.halsteadLength();
                return roundNumber(volume,2);
            };
            this.halsteadPotential = function() {
                if (this.halsteadLength() === 0) {
                    return sigDig(0, 3);
                }
                return sigDig(Math.log(3 + this.ins) / Math.LN2 * (3 + this.ins), 3);
            };
            this.halsteadLevel = function() {
                if (this.halsteadLength() === 0) {
                    return sigDig(0, 3);
                }
                return sigDig(this.halsteadPotential() / this.halsteadVolume(), 3);
            };
			this.halsteadDifficulty = function() {
				if (this.halsteadLength() === 0) {
                    return sigDig(0, 3);
                }				
                return (this.uniqueOperators() / 2) * (this.operandCount / this.uniqueOperands());
			}
			this.halsteadEffort = function() {
				if (this.halsteadLength() === 0) {
                    return sigDig(0, 3);
                }			
                return roundNumber(this.halsteadDifficulty() * this.halsteadVolume(), 2);
			}
            this.lines = function() {
                return this.lineEnd - this.lineStart + 1;
            };
			/*
            this.mi = function() {
                var result = sigDig(171 - 3.42 * Math.log(this.halsteadVolume()) - 0.23 * this.complexity() - 16.2 * Math.log(this.lines()) + 0.99 * this.comments, 5);
				if(isNaN(result)){
					return 0;
				}else{
					return result;
				}
            }*/
			
			this.mi = function() {
                var result = sigDig(171 - 5.2 * Math.log(this.halsteadVolume()) - 0.23 * this.complexity() - 16.2 * Math.log(this.lines()), 5);
				if(isNaN(result)){
					return 0;
				}else{
					return result;
				}
            }
			
			this.miSelf = function(avgVolume, avgComplexity, avgLOC) {
                var result = sigDig(171 - 5.2 * Math.log(avgVolume) - 0.23 * avgComplexity - 16.2 * Math.log(avgLOC), 5);
				if(isNaN(result)){
					return 0;
				}else{
					return result;
				}
            }
        
        },
        
        assembleNm = function(n) {
            var nm;
            if (n.arity==="binary") {
                nm = assembleNm(n.first) + (n.value||"") + assembleNm(n.second);
            } else {
                nm = n.value||"";
            }
            return nm!=="this"?nm:"";
        },
        
        isOperator = function(n) {
            if (n.arity === "unary" ||
                n.arity === "binary" ||
                n.arity === "ternary" ||
                isBranch(n) ||
                isBlock(n) ||
                isExit(n)) {
                    return true;   
            }
            return false;
        },
        
        isOperand = function(n) {
            return !(isOperator(n)) && n.arity!=="comment";
        },
        
        isBranch = function(n) {
            //returns true if this node causes branching
            return ["if", "else", "case", "default", "catch", "finally", "?", "for",
                "||", "&&"].indexOf(n.id)>=0;
        },
        
        isExit = function(n) {
            //return true if this node can cause the current function to exit
            return n.value==="return" || 
                    n.value==="thorw" ||
                    n.value==="exit";
        },
        
        isBlock = function(n) {
            //returns true if this node increases the depth of the function
            return n.value==="if" ||
                    n.value==="else" ||
                    n.value==="case" ||
                    n.value==="for";
        },
        
        extendName = function(n) {
            var nn = "";
            if (n.arity==="name" && n.value) {
                nn = nn + n.value;
            }
            if (n.value==="=" && n.first && n.first.arity==="name" && n.first.value) {
                nn = nn + n.first.value;
            }
            if (n.value==="{" && n.key) {
                nn = nn + n.key;
            }
            return nn;
        },
        
        arityStatementAdjustment = function(n) {
            var s = {    "unary" : 1,
                        "binary" : 2,
                        "ternary" : 3
                }[n.arity];
            return isNaN(s) ? 0 : s;
        },
        
        nodeCommentCount = function(n) {
            return n.comments ? n.comments.length : 0;
        },
        
        node = function(n, nn, depth) {
            var i;
            var ff;
            var nm = "";
            
            if (!n) {
                return;
            } else if (n instanceof Array) {
                //f.s+=1;
                for (i=0;i<n.length;i++) {
                    node(n[i], nn, depth);
                }
                return;
            }
            
            //window.status = "line: " + n.line + " depth: " + depth;
            
            f.blockDepth = Math.max(f.blockDepth, depth-f.depth);
            
            f.s+=1;
            
            pn = cn;
            cn = n;
            nn = nn ? (nn[nn.length-1]==="." ? nn : (nn + ".")) : "";
            
            f.s-=arityStatementAdjustment(n);
        	
            f.lineEnd = n.line;	
			
            //check to see if we should start a new function
            if (n.arity==="function" && (!pn || pn.arity!=="name")) {					
                f = new func(nn + (n.key || n.name || ""), f);
                f.comments += nodeCommentCount(n);
                fns.push(f);
                f.ins = n.first.length;
                node(n.second, nn, depth+1);
                f.parent.s += f.s + 1;
                f.parent.lineEnd = f.lineEnd;
                f.parent.comments += f.comments;
                f = f.parent;		
                return;
            } else if (n.second && n.second.arity === "function") {
                f.s+=1;
                i=0;
                nm = assembleNm(n.first);
                f = new func(nn + nm, f);
                f.comments += nodeCommentCount(n);
                fns.push(f);
                f.ins = n.second.first.length;
                node(n.second.second, nn, depth+1);
                f.parent.s += f.s + 1;
                f.parent.lineEnd = f.lineEnd;
                f.parent.comments += f.comments;
                f = f.parent;
                return;
            }
           
            //if this node does not begin a new function, measure
            f.comments += nodeCommentCount(n);
            nn = nn + extendName(n);
            if (isOperator(n)) {				
                f.operatorCount++;
                f.operators[n.value]=true;
            } else if (isOperand(n)){
                f.operandCount++;
                f.operands[n.value]=true;
            }
            
            if (isBranch(n)) {
                //if this node causes branching then,
                    //increment the nodes in the control flow graph
                    f.nodes++;  
                    
                    //from the new node in the control flow graph, add two edges
                    f.edges+=2; 
                    
                    //increment the count of branches
                    f.b+=1;
                    
                    //f.c+=1;
            }
            
            if (isExit(n)) {
                //if this node can cause the program to exit the current function
                    //increment the number of exits
                    f.exits+=1;					
            }
            
            if (isBlock(n)) {
                //if this node starts a nested depth then
                    //increment the current depth
                    depth++;    
                    
                    //check nested nodes
                    node(n.first, nn, depth);
                    node(n.second, nn, depth);
                    node(n.third, nn, depth);
                    
                    //after checking child nodes from the parse tree, 
                    //decrement the depth
                    depth--;
					
            } else {
            
                //check nested nodes
                node(n.first, nn, depth);
                node(n.second, nn, depth);
                node(n.third, nn, depth);
            
            }
        
        };
    
    itself.reset = function() {
    
        f = null;
        fns = [ ];
    
    };
        
    itself.complexity = function (tree, file) {
        f = null;
        pn = null; //previous node
        cn = null; //current node
        fns = [];
        
        var n;
        this.reset();
        this.tree = tree;
        f = new func("[[" + file + "]]");
        fns.push(f);
        if (tree instanceof Array) {
            for (n in tree) {
                if (!Object[n]) {
                    cn = null;
                    node(tree[n], null, 0);
                }
            }
        } else {
            cn = null;
            node(tree, null, 0);
        }
        
    };
    
    itself.getFunctions = function() {
        return fns;
    };
    
    itself.renderStats = function() {
        var i;
        var comp, mi, pl;
		
		var totalCC = 0;
		var totalLines = 0;
		var totalStatements = 0;
		var totalMI = 0;
		var totalVolume = 0;
		var totalEffort = 0;
		var totalFunctions = fns.length;
		var totalCommentLines = 0;
		
        var d = {
            text : "",
            write : function(t) {
                this.text = this.text + t;
            }
        };
		
        d.write("<table border=\"0\" >");
        d.write("<tr>");
        d.write("<th>");
        d.write("Line");
        d.write("</th>");
		
        d.write("<th>");
        d.write("Method");
        d.write("</th>");
		
		d.write("<th>");
        d.write("#");
        d.write("</th>");
		        
		d.write("<th>");
        d.write("CC");
        d.write("</th>");
		
		d.write("<th>");
        d.write("Volume");
        d.write("</th>");		
		
		d.write("<th>");
        d.write("Effort");
        d.write("</th>");	
                
		d.write("<th>");
        d.write("MI");
        d.write("</th>");	
		
        d.write("</tr>");
				
        for (i in fns) {
            if (!Object[i]) {
                comp = fns[i].complexity();
                mi = fns[i].mi();
                pl = fns[i].halsteadLevel();
				
				//
				totalCC += fns[i].complexity();
				totalStatements += fns[i].s;
				totalLines += fns[i].lines();
				totalCommentLines += fns[i].comments
				if (fns[i].halsteadEffort() != 0) {
					totalVolume += fns[i].halsteadVolume();
					totalEffort += fns[i].halsteadEffort();
					totalMI += new Number(fns[i].mi());					
				}
                //
				
                d.write("<tr>");
				
                d.write("<td>");
                d.write(fns[i].lineStart);
                d.write("</td>");
				
                d.write("<td>");
                d.write(fns[i].name.replace("[[code]].", ""));
                d.write("</td>");
				
				d.write("<td>");
                d.write('-');
                d.write("</td>");
				
                d.write("<td " + (comp>11?"style=\"color:red\"":"") + ">");
                d.write(comp);
                d.write("</td>");
				
				d.write("<td>");
                d.write(fns[i].halsteadVolume());
                d.write("</td>");
				
				d.write("<td>");
                d.write(fns[i].halsteadEffort());
                d.write("</td>");				
				
                d.write("<td " + (mi<100?"style=\"color:red\"":"") + ">");
                d.write(mi);
                d.write("</td>");
				
				
				
                d.write("</tr>");
            }
        }
		
		//Write SUM TOTALS
				
		d.write("<tr>");
				
        d.write("<td><strong>");
        d.write('-');
        d.write("</strong></td>");
		
        d.write("<td><strong>");
        d.write('Total (sum)');
        d.write("</strong></td>");
		
		//Method count
		d.write("<td><strong>");
        d.write(totalFunctions);
        d.write("</strong></td>");
				        
		//Cyclomatic Complexity		
        d.write("<td><strong>");
		d.write(totalCC);
        d.write("</strong></td>");
		
		//Halstead Volume
		d.write("<td><strong>");
        d.write(roundNumber(totalVolume, 2));
        d.write("</strong></td>");
		
		//Halstead Effort
		d.write("<td><strong>");
        d.write(totalEffort);
        d.write("</strong></td>");
		
		//Mantainability Index
        d.write("<td><strong>");
        d.write(totalMI);
        d.write("</strong></td>");
		
		
		
        d.write("</tr>");
		
		//
		
		//Write AVERAGE PER METHOD
				
		d.write("<tr>");
				
        d.write("<td><strong>");
        d.write('-');
        d.write("</strong></td>");
		
        d.write("<td><strong>");
        d.write('Total (avg/method)');
        d.write("</strong></td>");
		
		//Method count
		d.write("<td><strong>");
        d.write('-');
        d.write("</strong></td>");		
        
		//Cyclomatic Complexity		
        d.write("<td><strong>");
		d.write(roundNumber((totalCC/totalFunctions), 2));
        d.write("</strong></td>");
		
		//Halstead Volume
		d.write("<td><strong>");
        d.write(roundNumber((totalVolume / totalFunctions), 2));
        d.write("</strong></td>");
		
		//Halstead Effort
		d.write("<td><strong>");
        d.write(roundNumber((totalEffort / totalFunctions), 2));
        d.write("</strong></td>");
		
		//Mantainability Index
        d.write("<td><strong>");
        //d.write(this.miSelf());
        d.write("</strong></td>");
		
		
		
        d.write("</tr>");
		
		//
		
        d.write("</table>");
        
        /*
        d.write("<pre>" + JSON.stringify(tree, ['name', 'message', 'from', 'to', 'line', 'key',
                'value', 'arity', 'first', 'second', 'third', 'fourth', 'comments'], 4) + "</pre>");
        */
        
        /*elem.innerHTML = d.text; */
		return d.text;
    };
        
    return itself;
    
};

var COMPLEXITY = make_complexity();