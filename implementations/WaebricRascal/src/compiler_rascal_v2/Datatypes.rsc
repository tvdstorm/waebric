module compiler_rascal_v2::Datatypes
data Method = method(str id, list[str] args, list[str] body);
data Site = site(str id, str val);
data XmlNode = xmlnode(str id, list[XmlArgument] atrs);
data XmlArgument = xmlargument(str id, str attribute);