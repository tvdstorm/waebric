import java.io.IOException;
import java.io.Writer;
import java.io.StringWriter;
import java.io.FileWriter;
import java.io.File;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
 
@SuppressWarnings("unchecked")
public class test082 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test082().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	
{
final Object b = new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("x", "X");
	$v.putAll(new Hashtable<String,Object>()			
);
				return $v;
			}}.map();

			if (new Object() {
	public Object field() throws SQLException {
		Object $temp = b;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("x");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("x");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field() != null) {
				$out.write("Yes");

			}
			else {
				$out.write("No");

			}
    
}


}

public void main(final Writer $out)
	throws IOException, SQLException {
	main($out, $nil);
}

}
interface Markup {
	public void render(Writer out) throws IOException, SQLException;
}
interface Func10 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8,
		Object arg9,
		Object arg10)
		throws IOException, SQLException;
}
interface Func9 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8,
		Object arg9)
		throws IOException, SQLException;
}
interface Func8 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8)
		throws IOException, SQLException;
}
interface Func7 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7)
		throws IOException, SQLException;
}
interface Func6 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6)
		throws IOException, SQLException;
} 
interface Func5 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5)
		throws IOException, SQLException;
}
interface Func4 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4)
		throws IOException, SQLException;
}
interface Func3 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3)
		throws IOException, SQLException;
		}
interface Func2 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2)
		throws IOException, SQLException;
}
interface Func1 {
	public void call(Writer out, Markup markup, Object arg1)
		throws IOException, SQLException;
}
interface Func0 {
	public void call(Writer out, Markup markup)
		throws IOException, SQLException;
}
