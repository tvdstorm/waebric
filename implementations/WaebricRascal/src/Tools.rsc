module Tools
import String;
import IO;

/*
VAL_IN: 1
VAL_OUT: 1
FUNCTION: strip
*/
public str strip(str string){
	str toReturn = "";
	for(/<a:.+><b:[ \n]*>/ <-string){
		if(/^<code:.*>[\n]*;/ := a ){
			if(a!=";"){
				toReturn += "\n";
			}else println("a: <a>");
			toReturn += ""+code+";";
		}
		else{
			toReturn += "\n"+a;
		}
	}
	return toReturn;
}

/*
VAL_IN: 2
VAL_OUT: 2
FUNCTION: splitAtDot
*/
public tuple[str, str] splitAtDot(str inputStr){
	if(/^<begin:.*>\.<end:.*$>/ := inputStr ){
		return <begin, end>;
	}
	return <"","">;
}

/*
VAL_IN: 1
VAL_OUT: 1
FUNCTION: isNumber
*/
public bool isNumber(str string){
	if(/^[0123456789]*$/ := string){
		return true;
	}else{
		return false;
	}
}
