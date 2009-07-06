/**************************************************************************** 
 * Specifies a TextTail used in Embedding
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * Post TextTail Class
 * 
 * PostText -> TextTail
 * 
 * @param {Object} text
 */
function PostTextTail(text){
	this.text = text;
}

/**
 * Mid TextTail Class
 * 
 * MidText Embed TextTail -> TextTail
 * 
 * @param {Object} mid
 * @param {Object} embed
 * @param {Object} tail
 */
function MidTextTail(mid, embed, tail){
	this.mid = mid;
	this.embed = embed;
	this.tail = tail;
}