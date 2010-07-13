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
public class test093 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test093().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void on_the_wall(final Writer $out, final Markup $markup, final Object x) 
	throws IOException, SQLException {
	$out.write("");
$out.write(x.toString());
$out.write(" bottles of beer on the wall, ");
$out.write(x.toString());
$out.write(" bottles of beer.");

}

public void on_the_wall(final Writer $out, final Object x)
	throws IOException, SQLException {
	on_the_wall($out, $nil, x);
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
private void two(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
on_the_wall($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
$out.write("Take one down and pass it around, 1 bottle of beer on the wall.");

}});

}}, "2");

}});

}

public void two(final Writer $out)
	throws IOException, SQLException {
	two($out, $nil);
}
private void one(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
$out.write("1 bottle of beer on the wall, 1 bottle of beer.");

}});
line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
$out.write("Take one down and pass it around, no more bottles of beer on the wall.");

}});

}

public void one(final Writer $out)
	throws IOException, SQLException {
	one($out, $nil);
}
private void no_more(final Writer $out, final Markup $markup, final Object x) 
	throws IOException, SQLException {
	line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
$out.write("No more bottles of beer on the wall, no more bottles of beer.");

}});
line($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
$out.write("Go to the store and buy some more, ");
$out.write(x.toString());
$out.write(" bottles of beer on the wall.");

}});

}

public void no_more(final Writer $out, final Object x)
	throws IOException, SQLException {
	no_more($out, $nil, x);
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
				$v.addAll(new Object() {
			public List<Object> list() {
				List<Object> $v = new ArrayList<Object>()

;
				$v.add(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("cur", "96");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "95");
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
	$v.put("cur", "95");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "94");
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
	$v.put("cur", "94");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "93");
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
	$v.put("cur", "93");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "92");
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
	$v.put("cur", "92");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "91");
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
	$v.put("cur", "91");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "90");
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
	$v.put("cur", "90");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "89");
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
	$v.put("cur", "89");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "88");
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
	$v.put("cur", "88");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "87");
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
	$v.put("cur", "87");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "86");
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
	$v.put("cur", "86");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "85");
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
	$v.put("cur", "85");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "84");
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
	$v.put("cur", "84");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "83");
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
	$v.put("cur", "83");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "82");
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
	$v.put("cur", "82");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "81");
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
	$v.put("cur", "81");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "80");
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
	$v.put("cur", "80");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "79");
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
	$v.put("cur", "79");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "78");
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
	$v.put("cur", "78");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "77");
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
	$v.put("cur", "77");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "76");
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
	$v.put("cur", "76");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "75");
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
	$v.put("cur", "75");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "74");
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
	$v.put("cur", "74");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "73");
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
	$v.put("cur", "73");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "72");
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
	$v.put("cur", "72");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "71");
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
	$v.put("cur", "71");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "70");
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
	$v.put("cur", "70");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "69");
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
	$v.put("cur", "69");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "68");
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
	$v.put("cur", "68");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "67");
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
	$v.put("cur", "67");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "66");
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
	$v.put("cur", "66");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "65");
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
	$v.put("cur", "65");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "64");
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
	$v.put("cur", "64");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "63");
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
	$v.put("cur", "63");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "62");
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
	$v.put("cur", "62");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "61");
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
	$v.put("cur", "61");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "60");
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
	$v.put("cur", "60");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "59");
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
	$v.put("cur", "59");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "58");
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
	$v.put("cur", "58");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "57");
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
	$v.put("cur", "57");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "56");
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
	$v.put("cur", "56");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "55");
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
	$v.put("cur", "55");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "54");
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
	$v.put("cur", "54");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "53");
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
	$v.put("cur", "53");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "52");
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
	$v.put("cur", "52");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "51");
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
	$v.put("cur", "51");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "50");
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
	$v.put("cur", "50");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "49");
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
	$v.put("cur", "49");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "48");
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
	$v.put("cur", "48");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "47");
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
	$v.put("cur", "47");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "46");
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
	$v.put("cur", "46");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "45");
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
	$v.put("cur", "45");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "44");
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
	$v.put("cur", "44");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "43");
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
	$v.put("cur", "43");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "42");
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
	$v.put("cur", "42");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "41");
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
	$v.put("cur", "41");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "40");
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
	$v.put("cur", "40");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "39");
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
	$v.put("cur", "39");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "38");
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
	$v.put("cur", "38");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "37");
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
	$v.put("cur", "37");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "36");
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
	$v.put("cur", "36");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "35");
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
	$v.put("cur", "35");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "34");
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
	$v.put("cur", "34");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "33");
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
	$v.put("cur", "33");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "32");
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
	$v.put("cur", "32");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "31");
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
	$v.put("cur", "31");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "30");
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
	$v.put("cur", "30");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "29");
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
	$v.put("cur", "29");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "28");
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
	$v.put("cur", "28");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "27");
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
	$v.put("cur", "27");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "26");
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
	$v.put("cur", "26");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "25");
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
	$v.put("cur", "25");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "24");
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
	$v.put("cur", "24");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "23");
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
	$v.put("cur", "23");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "22");
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
	$v.put("cur", "22");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "21");
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
	$v.put("cur", "21");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "20");
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
	$v.put("cur", "20");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "19");
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
	$v.put("cur", "19");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "18");
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
	$v.put("cur", "18");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "17");
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
	$v.put("cur", "17");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "16");
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
	$v.put("cur", "16");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "15");
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
	$v.put("cur", "15");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "14");
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
	$v.put("cur", "14");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "13");
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
	$v.put("cur", "13");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "12");
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
	$v.put("cur", "12");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "11");
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
	$v.put("cur", "11");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "10");
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
	$v.put("cur", "10");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "9");
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
	$v.put("cur", "9");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "8");
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
	$v.put("cur", "8");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "7");
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
	$v.put("cur", "7");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "6");
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
	$v.put("cur", "6");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "5");
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
	$v.put("cur", "5");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "4");
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
	$v.put("cur", "4");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "3");
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
	$v.put("cur", "3");
	$v.putAll(new Object() {
			public Map<String,Object> map() {
				Map<String,Object> $v = new Hashtable<String,Object>()
;
	$v.put("next", "2");
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
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
					return $v;
				}}.list());
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
on_the_wall($out, $nil, new Object() {
	public Object field() throws SQLException {
		Object $temp = n;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("cur");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("cur");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field());
}});
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
on_the_wall($out, $nil, new Object() {
	public Object field() throws SQLException {
		Object $temp = n;
		Object $result = "null";
		if ($temp instanceof Map) {
			$result = (Map<String,Object>)$temp.
				get("cur");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject("cur");
			
		}
		else {
			$result = "<invalid type for field dereference " +
				$temp.getClass().toString() + ">";
		}
		return $result;
	}
}.field());
}});
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
    two($out, $nil);
    one($out, $nil);
    no_more($out, $nil, "99");    
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
