package org.cwi.waebric.parser.ast.statement.embedding;

import org.cwi.waebric.parser.ast.AbstractSyntaxNode;
import org.cwi.waebric.parser.ast.INodeVisitor;

/**
 * Text tail
 * 
 * @author Jeroen van Schagen
 * @date 02-06-2009
 */
public abstract class TextTail extends AbstractSyntaxNode {

	/**
	 * > TextChar* " -> PostText<br>
	 * PostText -> TextTail
	 */
	public static class PostTail extends TextTail {
		
		private PostText post;
		
		public PostTail() { }

		public PostTail(PostText post) {
			this.post = post;
		}
		
		public PostText getPost() {
			return post;
		}

		public void setPost(PostText post) {
			this.post = post;
		}

		public AbstractSyntaxNode[] getChildren() {
			return new AbstractSyntaxNode[] { post };
		}
		
		@Override
		public void accept(INodeVisitor visitor) {
			visitor.visit(this);
		}
		
	}
	
	/**
	 * > TextChar* < -> MidText <br>
	 * MidText Embed TextTail -> TextTail
	 */
	public static class MidTail extends TextTail {

		private MidText mid;
		private Embed embed;
		private TextTail tail;
		
		public MidText getMid() {
			return mid;
		}

		public void setMid(MidText mid) {
			this.mid = mid;
		}

		public Embed getEmbed() {
			return embed;
		}

		public void setEmbed(Embed embed) {
			this.embed = embed;
		}

		public TextTail getTail() {
			return tail;
		}

		public void setTail(TextTail tail) {
			this.tail = tail;
		}

		public AbstractSyntaxNode[] getChildren() {
			return new AbstractSyntaxNode[] { mid, embed, tail };
		}
		
		@Override
		public void accept(INodeVisitor visitor) {
			visitor.visit(this);
		}
		
	}
	
}