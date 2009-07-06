/**************************************************************************** 
 * Specifies an attributes used in a designator tag 
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/** 
 * ID Attribute Class
 * 
 * "#" IdCon -> Attribute ("id")
 * 
 * @param {object} identifier
 */
function IdAttribute(id){
	this.id = id;
	
	this.toString = idAttributeToString;
}

/** 
 * Class Attribute Class
 * 
 * "." IdCon -> Attribute ("class")
 * 
 * @param {object} class
 */
function ClassAttribute(className){
	this.className = className;
	
	this.toString = classAttributeToString;
}

/** 
 * Name Attribute Class
 * 
 * "$" IdCon -> Attribute ("name")
 * 
 * @param {object} name
 */
function NameAttribute(name){
	this.name = name;
	
	this.toString = nameAttributeToString;
}

/** 
 * Type Attribute Class
 * 
 * ":" IdCon -> Attribute ("type")
 * 
 * @param {object} type
 */
function TypeAttribute(type){
	this.type = type;
	
	this.toString = typeAttributeToString;
}

/** 
 * Width Height Attribute Class
 * 
 * "@" NatCon "%" NatCon -> Attribute ("width-height")
 * 
 * @param {object} width
 * @param {object} height
 */
function WidthHeightAttribute(width, height){
	this.width = width;
	this.height = height;
	
	this.toString = widthHeightAttributeToString;
}

/** 
 * WidthAttribute Class
 * 
 * "@" NatCon -> Attribute  ("height")
 * 
 * @param {object} height
 */
function WidthAttribute(width){
	this.width = width;
	
	this.toString = widthAttributeToString;
}



function attributeToString(){
	return this.variable + "=" + this.expression;
}

function idAttributeToString(){
	return 'NYI';
}

function classAttributeToString(){
	return 'NYI';
}

function nameAttributeToString(){
	return 'NYI';
}

function typeAttributeToString(){
	return 'NYI';
}

function widthHeightAttributeToString(){
	return 'NYI';
}

function widthAttributeToString(){
	return 'NYI';
}
