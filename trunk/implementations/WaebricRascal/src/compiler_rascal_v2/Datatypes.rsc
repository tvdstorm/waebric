module compiler_rascal_v2::Datatypes
import languages::waebric::syntax::Waebric;
data Allocation = allocation(str getId, list[node] args, node val);
data Method = method(str getName, list[str] args, list[str] body);
data Website = website(str getPath, str getMarkup);
data MarkupData = markupdata(XmlNode getXmlnode, list[Argument] getArgs);
data XmlNode = xmlnode(str getType, list[XmlArgument] getXmlarguments);
data XmlArgument = xmlargument(str getId, str getArgument);