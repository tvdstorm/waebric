module compiler_rascal_v2::Datatypes
import languages::waebric::syntax::Waebric;
data Allocation = allocation(str id, list[node] args, node val);
data Method = method(str id, list[str] args, list[str] body);
data Website = website(str id, str val);
data MarkupData = markupdata(XmlNode nod, list[Argument] args);
data XmlNode = xmlnode(str node_type, list[XmlArgument] atrs);
data XmlArgument = xmlargument(str id, str attribute);