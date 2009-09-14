module waebric::XHTML


public set[str] XHTML_ELEMENTS = {"a", "abbr", "acronym", "address", "applet", "area", "b", "base",
"basefont", "bdo", "big", "blockquote", "body", "br", "button",
"caption", "center", "cite", "code", "col", "colgroup", "dd", "del",
"dfn", "dir", "div", "dl", "dt", "em", "fieldset", "font", "form",
"frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "hr",
"html", "i", "iframe", "img", "input", "ins", "isindex", "kbd",
"label", "legend", "li", "link", "map", "menu", "meta", "noframes",
"noscript", "object", "ol", "optgroup", "option", "p", "param", "pre",
"q", "s", "samp", "script", "select", "small", "span", "strike",
"strong", "style", "sub", "sup", "table", "tbody", "td", "textarea",
"tfoot", "th", "thead", "title", "tr", "tt", "u", "ul", "var"};


public set[str] XHTML_DEPRECATED = {"applet", "basefont", "center", "dir", "font", "isindex", "menu",
"s", "strike", "u"};

public set[str] XHTML_NO_END_TAGS = {"area", "base", "basefont", "br", "col", "frame", "hr", "img",
"input", "isindex", "link", "meta", "param"};

public rel[str,str] XHTML_ATTRIBUTES = {};

