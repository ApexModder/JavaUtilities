package xyz.apex.java.utility.immutable;

import xyz.apex.java.utility.tuple.Pair;
import xyz.apex.java.utility.tuple.Triple;

/**
 * Object containing 3 elements of differing types.
 * <br>
 * This object is <b>Immutable</b>, this means all elements can <b>not</b> be modified.
 * <br>
 * All <em>setter</em> methods will throw {@link UnsupportedOperationException} if called.
 *
 * @param <L> The base object type for the <em>key/left</em> element.
 * @param <M> The base object type for the <em>value/middle</em> element.
 * @param <R> The base object type for the <em>right</em> element.
 * @see Pair
 * @see Triple
 * @since 1.0.1-J8
 */
public class ImmutableTriple<L, M, R> extends ImmutablePair<L, M> implements Triple<L, M, R>
{
	public final R right;

	public ImmutableTriple(L left, M middle, R right)
	{
		super(left, middle);

		this.right = right;
	}

	/**
	 * Set the <em>left</em> element value.
	 *
	 * @param left The new <em>left</em> element value.
	 * @return The old <em>left</em> element value.
	 * @see Pair#setKey(Object)
	 * @since 1.0.1-J8
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final L setLeft(L left)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>left</em> element value.
	 *
	 * @return The current <em>left</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public final L getLeft()
	{
		return getKey();
	}

	/**
	 * Set the <em>middle</em> element value.
	 *
	 * @param middle The new <em>middle</em> element value.
	 * @return The old <em>middle</em> element value.
	 * @see Pair#setValue(Object)
	 * @see #setMiddle(Object)
	 * @since 1.0.1-J8
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final M setMiddle(M middle)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>middle</em> element value.
	 *
	 * @return The current <em>middle</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public final M getMiddle()
	{
		return getValue();
	}

	/**
	 * Set the <em>right</em> element value.
	 *
	 * @param right The new <em>middle</em> element value.
	 * @return The old <em>right</em> element value.
	 * @since 1.0.1-J8
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final R setRight(R right)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>right</em> element value.
	 *
	 * @return The current <em>right</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public final R getRight()
	{
		return right;
	}
}
