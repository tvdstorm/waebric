module compiler_rascal_v2::Datatypes
import languages::waebric::syntax::Waebric;
data Method = method(str id, list[str] args, list[str] body);
data Website = website(str id, str val);
data XmlNode = xmlnode(str id, list[XmlArgument] atrs);
data XmlArgument = xmlargument(str id, str attribute);
data MarkupData = markupdata(XmlNode nod, list[Argument] args);