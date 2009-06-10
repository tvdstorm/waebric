package org.cwi.waebric.parser.ast.module.function;

import java.util.List;

import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.AbstractSyntaxNodeList;
import org.cwi.waebric.parser.ast.CharacterLiteral;
import org.cwi.waebric.parser.ast.AbstractSyntaxNode;
import org.cwi.waebric.parser.ast.AbstractSyntaxNodeList.AbstractSeparatedSyntaxNodeList;
import org.cwi.waebric.parser.ast.basic.IdCon;

/**
 * @see RegularFormals
 * @see EmptyFormals
 * 
 * @author Jeroen van Schagen
 * @date 09-06-2009
 */
public abstract class Formals extends AbstractSyntaxNode {
	
	public abstract List<IdCon> getIdentifiers();

	/**
	 * "(" { IdCon "," }* ")" -> Formals
	 * @author Jeroen van Schagen
	 * @date 26-05-2009
	 */
	public static class RegularFormal extends Formals {
		
		private AbstractSeparatedSyntaxNodeList<IdCon> identifiers;
		
		/**
		 * Construct regular formal
		 */
		public RegularFormal() {
			this.identifiers = new AbstractSeparatedSyntaxNodeList<IdCon>(WaebricSymbol.COMMA);
		}

		public boolean addIdentifier(IdCon identifier) {
			return identifiers.add(identifier);
		}
		
		public List<IdCon> getIdentifiers() {
			return identifiers.clone();
		}
		
		public AbstractSyntaxNode[] getChildren() {
			return new AbstractSyntaxNode[] {
				new CharacterLiteral(WaebricSymbol.LPARANTHESIS),
				identifiers,
				new CharacterLiteral(WaebricSymbol.RPARANTHESIS)
			};
		}

	}
	
	/**
	 *  -> Formals
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	public static class EmptyFormal extends Formals {
		
		public AbstractSyntaxNode[] getChildren() {
			return new AbstractSyntaxNode[]{};
		}

		@Override
		public List<IdCon> getIdentifiers() {
			return new AbstractSyntaxNodeList<IdCon>();
		}
		
	}

}