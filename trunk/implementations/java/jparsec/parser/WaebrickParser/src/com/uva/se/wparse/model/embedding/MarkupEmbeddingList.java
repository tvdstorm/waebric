package com.uva.se.wparse.model.embedding;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'each' construction. It is an
 * implementation of embedding weabric parts.
 */
public class MarkupEmbeddingList extends WaebricParseTreeNode 
	implements Embedding {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupEmbeddingList.class);

	/**
	 * Contains a list of MarkupEmbedding objects, if there are more then 1
	 * items in the list the postText property of the objects ( instead of the
	 * last object in the list) must be treated as midtext.
	 */
	private List<Embedding> embedding = null;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param embedding
	 *            The list with all the embeddings.
	 */
	public MarkupEmbeddingList(List<Embedding> embedding) {
		this.embedding = embedding;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return Strings.join("", embedding);
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String embeddingList = "";
		for (Embedding embedItem : embedding) {
			embeddingList = outputAddToBlock(embeddingList, embedItem
					.toTransformerOutput());
		}

		return embeddingList;
	}
}
