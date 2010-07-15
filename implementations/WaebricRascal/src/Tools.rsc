module Tools
import String;
import IO;


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
public tuple[str, str] splitAtDot(str inputStr){
	if(/^<begin:.*>\.<end:.*$>/ := inputStr ){
		return <begin, end>;
	}
	return <"","">;
}
public bool isNumber(str string){
	if(/^[0123456789]*$/ := string){
		return true;
	}else{
		return false;
	}
}
