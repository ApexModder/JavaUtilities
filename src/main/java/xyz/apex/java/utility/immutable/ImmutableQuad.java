package xyz.apex.java.utility.immutable;

import xyz.apex.java.utility.api.tuple.Pair;
import xyz.apex.java.utility.api.tuple.Quad;
import xyz.apex.java.utility.api.tuple.Triple;

/**
 * Object containing 4 elements of differing types.
 * <br>
 * This object is <b>Immutable</b>, this means all elements can <b>not</b> be modified.
 * <br>
 * All <em>setter</em> methods will throw {@link UnsupportedOperationException} if called.
 *
 * @param <A> The base object type for the <em>key/left/first</em> element.
 * @param <B> The base object type for the <em>value/middle/second</em> element.
 * @param <C> The base object type for the <em>third</em> element.
 * @see Pair
 * @see Triple
 * @see Quad
 */
public class ImmutableQuad<A, B, C, D> extends ImmutableTriple<A, B, C> implements Quad<A, B, C, D>
{
	public final D fourth;

	public ImmutableQuad(A first, B second, C third, D fourth)
	{
		super(first, second, third);

		this.fourth = fourth;
	}

	/**
	 * Set the <em>first</em> element value.
	 *
	 * @param first The new <em>first</em> element value.
	 * @return The old <em>first</em> element value.
	 * @see Pair#setKey(Object)
	 * @see Triple#setLeft(Object)
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final A setFirst(A first)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>first</em> element value.
	 *
	 * @return The current <em>first</em> element value.
	 */
	@Override
	public final A getFirst()
	{
		return getKey();
	}

	/**
	 * Set the <em>second</em> element value.
	 *
	 * @param second The new <em>second</em> element value.
	 * @return The old <em>second</em> element value.
	 * @see Pair#setValue(Object)
	 * @see Triple#setMiddle(Object)
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final B setSecond(B second)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>second</em> element value.
	 *
	 * @return The current <em>second</em> element value.
	 */
	@Override
	public final B getSecond()
	{
		return getValue();
	}

	/**
	 * Set the <em>third</em> element value.
	 *
	 * @param third The new <em>third</em> element value.
	 * @return The old <em>third</em> element value.
	 * @see Triple#setRight(Object)
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final C setThird(C third)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>third</em> element value.
	 *
	 * @return The current <em>third</em> element value.
	 */
	@Override
	public final C getThird()
	{
		return getRight();
	}

	/**
	 * Set the <em>fourth</em> element value.
	 *
	 * @param fourth The new <em>fourth</em> element value.
	 * @return The old <em>fourth</em> element value.
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final D setFourth(D fourth)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>fourth</em> element value.
	 *
	 * @return The current <em>fourth</em> element value.
	 */
	@Override
	public final D getFourth()
	{
		return fourth;
	}
}