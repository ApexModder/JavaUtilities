package xyz.apex.java.utility.api.tuple;

import xyz.apex.java.utility.api.JavaUtilities;

/**
 * Object containing 3 elements of differing types.
 *
 * @param <L> The base object type for the <em>key/left</em> element.
 * @param <M> The base object type for the <em>value/middle</em> element.
 * @param <R> The base object type for the <em>right</em> element.
 * @see Pair
 */
public interface Triple<L, M, R> extends Pair<L, M>
{
	/**
	 * Set the <em>left</em> element value.
	 *
	 * @param left The new <em>left</em> element value.
	 * @return The old <em>left</em> element value.
	 * @see Pair#setKey(Object)
	 */
	L setLeft(L left);

	/**
	 * Set the <em>left</em> element value.
	 *
	 * @param left The new <em>left</em> element value.
	 * @return The old <em>left</em> element value.
	 * @see Pair#setKey(Object)
	 * @see #setLeft(Object)
	 */
	@Override L setKey(L left);

	/**
	 * Get the current <em>left</em> element value.
	 *
	 * @return The current <em>left</em> element value.
	 */
	L getLeft();

	/**
	 * Get the current <em>left</em> element value.
	 *
	 * @return The current <em>left</em> element value.
	 * @see Pair#getKey()
	 * @see #getLeft()
	 */
	@Override L getKey();

	/**
	 * Set the <em>middle</em> element value.
	 *
	 * @param middle The new <em>middle</em> element value.
	 * @return The old <em>middle</em> element value.
	 * @see Pair#setValue(Object)
	 * @see #setMiddle(Object)
	 */
	M setMiddle(M middle);

	/**
	 * Set the <em>middle</em> element value.
	 *
	 * @param middle The new <em>middle</em> element value.
	 * @return The old <em>middle</em> element value.
	 * @see Pair#setValue(Object)
	 */
	@Override M setValue(M middle);

	/**
	 * Get the current <em>middle</em> element value.
	 *
	 * @return The current <em>middle</em> element value.
	 */
	M getMiddle();

	/**
	 * Get the current <em>middle</em> element value.
	 *
	 * @return The current <em>middle</em> element value.
	 * @see Pair#getValue()
	 * @see #getMiddle()
	 */
	@Override M getValue();

	/**
	 * Set the <em>right</em> element value.
	 *
	 * @param right The new <em>middle</em> element value.
	 * @return The old <em>right</em> element value.
	 */
	R setRight(R right);

	/**
	 * Get the current <em>right</em> element value.
	 *
	 * @return The current <em>right</em> element value.
	 */
	R getRight();

	/**
	 * Creates a new {@link Triple} from the given <em>left, middle, right</em> elements.
	 *
	 * @param left The <em>left</em> element of the built {@link Triple}.
	 * @param middle The <em>middle</em> element of the built {@link Triple}.
	 * @param right The <em>right</em> element of the built {@link Triple}.
	 * @param <L> The base object type for the <em>left</em> element.
	 * @param <M> The base object type for the <em>middle</em> element.
	 * @param <R> The base object type for the <em>right</em> element.
	 * @return {@link Triple} built from the given <em>left, middle, right</em> elements.
	 */
	static <L, M, R> Triple<L, M, R> create(L left, M middle, R right)
	{
		return JavaUtilities.INSTANCE.createMutableTriple(left, middle, right);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Triple} from the given <em>left, middle, right</em> elements.
	 *
	 * @param left The <em>left</em> element of the built {@link Triple}.
	 * @param middle The <em>middle</em> element of the built {@link Triple}.
	 * @param right The <em>right</em> element of the built {@link Triple}.
	 * @param <L> The base object type for the <em>left</em> element.
	 * @param <M> The base object type for the <em>middle</em> element.
	 * @param <R> The base object type for the <em>right</em> element.
	 * @return {@link Triple} built from the given <em>left, middle, right</em> elements.
	 */
	static <L, M, R> Triple<L, M, R> createImmutable(L left, M middle, R right)
	{
		return JavaUtilities.INSTANCE.createImmutableTriple(left, middle, right);
	}
}