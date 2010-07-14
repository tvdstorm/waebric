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
public class test061 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test061().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void menu(final Writer $out, final Markup $markup, final Object menu) 
	throws IOException, SQLException {
	$out.write(new Object() {
	public Object field() throws SQLException {
		Object $temp = menu;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("title");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("title");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field().toString());
$out.write("<ul>");

new Object() {
public void each(final Writer $out) 
	throws IOException, 
		SQLException  {
Object $temp = new Object() {
	public Object field() throws SQLException {
		Object $temp = menu;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("kids");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("kids");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field();
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
			Map<String,Object> kid = 
				new Hashtable<String,Object>();
			for (int $i = 0; $i < $meta.getColumnCount(); $i++) {
				kid.put($meta.getColumnName($i), "null");
			}
			while ($rs.next()) {
				for (String $k: kid.keySet()) {
					Object $v = $rs.getObject($k);
					if ($v != null) {
						kid.put($k, $v);
					}
					else {
						kid.put($k, "null");
					}
					item($out, $nil, kid);;
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
			for (final Object kid: $iter) {
				item($out, $nil, kid);
			}
			}
		}.each($out);
$out.write("</ul>");

}

public void menu(final Writer $out, final Object menu)
	throws IOException, SQLException {
	menu($out, $nil, menu);
}
private void item(final Writer $out, final Markup $markup, final Object mi) 
	throws IOException, SQLException {
	$out.write("<li>");

			if (new Object() {
	public Object field() throws SQLException {
		Object $temp = mi;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("kids");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("kids");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field() != null) {
				menu($out, $nil, mi);

			}
			else {
				$out.write("<a");
$out.write(" href=\"" + new Object() {
	public Object field() throws SQLException {
		Object $temp = mi;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("link");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("link");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field() + "\"");
$out.write(">");
$out.write(new Object() {
	public Object field() throws SQLException {
		Object $temp = mi;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("title");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("title");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field().toString());
$out.write("</a>");

			}
$out.write("</li>");

}

public void item(final Writer $out, final Object mi)
	throws IOException, SQLException {
	item($out, $nil, mi);
}
private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	menu($out, $nil, new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("title", "Menu");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("kids", new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("title", "Home");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("link", "/");
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
	$v.put("title", "Misc");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("kids", new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()
;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("title", "Contact");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("link", "contact.html");
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
	$v.put("title", "Links");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("link", "links.html");
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
	$v.putAll(new Hashtable<String,Object>()			
);
				return $v;
			}}.map());
				return $v;
			}}.map());

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
