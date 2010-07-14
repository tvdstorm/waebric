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
public class test054 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test054().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	
new Object() {
public void each(final Writer $out) 
	throws IOException, 
		SQLException  {

Object $temp = new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add("1");
				$v.addAll(new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add("2");
				$v.addAll(new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add("3");
	$v.addAll(new ArrayList<Object>()
);
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list();
	Iterable<Object> $iter;
	if ($temp instanceof Iterable) {
		$iter = (Iterable<Object>)$temp;
	}
	else if ($temp instanceof Map) {
		List<Object> $list = new ArrayList<Object>()

;
		for (Map.Entry<String,Object> $entry: (Map<String,Object>)$temp.entrySet()) {
			List<Object> $tuple = new ArrayList<Object>()

;
			$tuple.add($entry.getKey());
			$tuple.add($entry.getValue());
			$list.add($tuple);
		}
		$iter = $list;
	}
	else if ($temp instanceof ResultSet) {
		ResultSet $rs = (ResultSet)$temp;
		boolean $first = $rs.first();
		if (!$first) {
			return;
		}
		ResultSetMetaData $meta = 
			$rs.getMetaData();
		Map<String,Object> x = 
			new Hashtable<String,Object>();
		for (int $i = 0; $i < $meta.getColumnCount(); $i++) {
			x.put($meta.getColumnName($i), "null");
		}
		while ($rs.next()) {
			for (String $k: x.keySet()) {
				Object $v = $rs.getObject($k);
				if ($v != null) {
					x.put($k, $v);
				}
				else {
					x.put($k, "null");
				}

				
			if ("1" != null) {
				
			if (b != null) {
				$out.write("2");
			}
			else {
				$out.write("innermost else");
			}
			};
			}
		}				
		return;
	}
	else {
		List<Object> $single = new ArrayList<Object>()

;
			$single.add($temp);
			$iter = $single;
		}
		for (final Object x: $iter) {
			
			if ("1" != null) {
				
			if (b != null) {
				$out.write("2");

			}
			else {
				$out.write("innermost else");

			}

			}

		}
		}
	}.each($out);

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
