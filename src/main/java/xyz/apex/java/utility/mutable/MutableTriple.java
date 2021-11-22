package xyz.apex.java.utility.mutable;

import xyz.apex.java.utility.tuple.Pair;
import xyz.apex.java.utility.tuple.Triple;

/**
 * Object containing 3 elements of differing types.
 * <br>
 * This object is <b>Mutable</b>, this means all elements <b>can</b> be modified with no side effects.
 *
 * @param <L> The base object type for the <em>key/left</em> element.
 * @param <M> The base object type for the <em>value/middle</em> element.
 * @param <R> The base object type for the <em>right</em> element.
 * @see Pair
 * @see Triple
 * @since 1.0.1-J8
 */
public class MutableTriple<L, M, R> extends MutablePair<L, M> implements Triple<L, M, R>
{
	public R right;

	public MutableTriple(L left, M middle, R right)
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
	 */
	@Override
	public L setLeft(L left)
	{
		return setKey(left);
	}

	/**
	 * Get the current <em>left</em> element value.
	 *
	 * @return The current <em>left</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public L getLeft()
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
	 */
	@Override
	public M setMiddle(M middle)
	{
		return setValue(middle);
	}

	/**
	 * Get the current <em>middle</em> element value.
	 *
	 * @return The current <em>middle</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public M getMiddle()
	{
		return getValue();
	}

	/**
	 * Set the <em>right</em> element value.
	 *
	 * @param right The new <em>middle</em> element value.
	 * @return The old <em>right</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public R setRight(R right)
	{
		R oldRight = this.right;
		this.right = right;
		return oldRight;
	}

	/**
	 * Get the current <em>right</em> element value.
	 *
	 * @return The current <em>right</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public R getRight()
	{
		return right;
	}
}
