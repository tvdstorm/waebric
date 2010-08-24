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
public class test099 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test099().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void swfobject(final Writer $out, final Markup $markup, final Object url, final Object width, final Object height, final Object id) 
	throws IOException, SQLException {
	$out.write("<object");
$out.write(" "); 
$out.write("classid=\"" + "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" );
$out.write("\"");
$out.write(" "); 
$out.write("width=\"" + width );
$out.write("\"");
$out.write(" height=\"" + height + "\"");
$out.write(">");


$out.write("<" + "param");
$out.write(" ");
$out.write("name=\"" + "movie" );
$out.write("\"");
$out.write(" value=\"" + url + "\"");;
$out.write(" />");
    $out.write("<" + "param");
$out.write(" ");
$out.write("name=\"" + "quality" );
$out.write("\"");
$out.write(" value=\"" + "high" + "\"");;
$out.write(" />");
    $out.write("<" + "param");
$out.write(" ");
$out.write("name=\"" + "bgcolor" );
$out.write("\"");
$out.write(" value=\"" + "#fffce6" + "\"");;
$out.write(" />");
    $out.write("<!--[if !IE]>-->");    $out.write("<object");
$out.write(" "); 
$out.write("type=\"" + "application/x-shockwave-flash" );
$out.write("\"");
$out.write(" "); 
$out.write("data=\"" + url );
$out.write("\"");
$out.write(" "); 
$out.write("width=\"" + width );
$out.write("\"");
$out.write(" height=\"" + height + "\"");
$out.write(">");



$out.write("<" + "param");
$out.write(" ");
$out.write("name=\"" + "quality" );
$out.write("\"");
$out.write(" value=\"" + "high" + "\"");;
$out.write(" />");
    $out.write("<" + "param");
$out.write(" ");
$out.write("name=\"" + "bgcolor" );
$out.write("\"");
$out.write(" value=\"" + "#fffce6" + "\"");;
$out.write(" />");
    $out.write("<!--<![endif]-->");    $out.write("<!--[if !IE]>-->");    $out.write("</object>");
    $out.write("<!--<![endif]-->");    $out.write("</object>");

}
public void swfobject(final Writer $out, final Object url, final Object width, final Object height, final Object id)
	throws IOException, SQLException {
	swfobject($out, $nil, url, width, height, id);
}
private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	swfobject($out, $nil, "htt://google.nl", "232", "3875", "swfobject");

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
