module Tools
import String;
import IO;

/* FUNCTION (1->1): strip */
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

/* FUNCTION (1->1): splitAtDot */
public tuple[str, str] splitAtDot(str inputStr){
	if(/^<begin:.*>\.<end:.*$>/ := inputStr ){
		return <begin, end>;
	}
	return <"","">;
}

/* FUNCTION (1->1): isNumber */
public bool isNumber(str string){
	if(/^[0123456789]*$/ := string){
		return true;
	}else{
		return false;
	}
}