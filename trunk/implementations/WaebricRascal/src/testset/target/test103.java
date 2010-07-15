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
public class test103 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test103().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void take_one_down(final Writer $out, final Markup $markup, final Object x) 
	throws IOException, SQLException {
	$out.write("Take one down and pass it around, ");
$out.write(x.toString());
$out.write(" bottles of beer on the wall.");

}

public void take_one_down(final Writer $out, final Object x)
	throws IOException, SQLException {
	take_one_down($out, $nil, x);
}
private void line(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	$out.write("<li>");
$markup.render($out);
$out.write("</li>");

}

public void line(final Writer $out)
	throws IOException, SQLException {
	line($out, $nil);
}
private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	
{
final Object iter = new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("cur", "99");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "98");
	$v.putAll(new Hashtable<String,Object>()			
);
				return $v;
			}}.map());
				return $v;
			}}.map());
				$v.addAll(new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("cur", "98");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "97");
	$v.putAll(new Hashtable<String,Object>()			
);
				return $v;
			}}.map());
				return $v;
			}}.map());
				$v.addAll(new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("cur", "97");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "96");
	$v.putAll(new Hashtable<String,Object>()			
);
				return $v;
			}}.map());
				return $v;
			}}.map());
	$v.addAll(new ArrayList<Object>()
);
	return $v;
	}}.list());
	return $v;
	}}.list());
	return $v;
	}}.list();

new Object() {
public void each(final Writer $out) 
	throws IOException, 
		SQLException  {
Object $temp = iter;
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
		Map<String,Object> n = 
			new Hashtable<String,Object>();
		for (int $i = 0; $i < $meta.getColumnCount(); $i++) {
			n.put($meta.getColumnName($i), "null");
		}
		while ($rs.next()) {
			for (String $k: n.keySet()) {
				Object $v = $rs.getObject($k);
				if ($v != null) {
					n.put($k, $v);
				}
				else {
					n.put($k, "null");
				}

				
line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
take_one_down($out, $nil, new Object() {
	public Object field() throws SQLException {
		Object $temp = n;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("next");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("next");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field());
}});;
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
		for (final Object n: $iter) {
			line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
take_one_down($out, $nil, new Object() {
	public Object field() throws SQLException {
		Object $temp = n;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("next");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("next");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field());
}});
    
		}
		}
	}.each($out);
    
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
