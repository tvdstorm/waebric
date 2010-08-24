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
public class test100 {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new test100().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(".");
	}

	private void main(final Writer $out, final Markup $markup) 
	throws IOException, SQLException {
	$out.write("<h2>");
$out.write("Important Dates");
$out.write("</h2>");
$out.write("<table>");
$out.write("<tr>");
$out.write("<td>");
$out.write("<b>");
$out.write("Abstract submission deadline:");
$out.write("</b>");
$out.write("</td>");
    $out.write("<td>");
$out.write("Friday November 28th, 2008");
$out.write("</td>");
    $out.write("</tr>");
    $out.write("<tr>");
$out.write("<td>");
$out.write("<b>");
$out.write("Paper submission deadline:");
$out.write("</b>");
$out.write("</td>");
    $out.write("<td>");
$out.write("Friday December 5th, 2008");
$out.write("</td>");
    $out.write("</tr>");
    $out.write("<tr>");
$out.write("<td>");
$out.write("<b>");
$out.write("Notification of acceptance:");
$out.write("</b>");
$out.write("</td>");
    $out.write("<td>");
$out.write("Friday February 6th, 2009");
$out.write("</td>");
    $out.write("</tr>");
    $out.write("<tr>");
$out.write("<td>");
$out.write("<b>");
$out.write("Workshop date:");
$out.write("</b>");
$out.write("</td>");
    $out.write("<td>");
$out.write("20th March 20th, 2009 (tentative)");
$out.write("</td>");
    $out.write("</tr>");
    $out.write("</table>");

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
