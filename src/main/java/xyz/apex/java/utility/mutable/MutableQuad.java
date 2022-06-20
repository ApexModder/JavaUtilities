package xyz.apex.java.utility.mutable;

import xyz.apex.java.utility.tuple.Pair;
import xyz.apex.java.utility.tuple.Quad;
import xyz.apex.java.utility.tuple.Triple;

/**
 * Object containing 4 elements of differing types.
 * <br>
 * This object is <b>Mutable</b>, this means all elements <b>can</b> be modified with no side effects.
 *
 * @param <A> The base object type for the <em>key/left/first</em> element.
 * @param <B> The base object type for the <em>value/middle/second</em> element.
 * @param <C> The base object type for the <em>third</em> element.
 * @see Pair
 * @see Triple
 * @see Quad
 */
public class MutableQuad<A, B, C, D> extends MutableTriple<A, B, C> implements Quad<A, B, C, D>
{
	public D fourth;

	public MutableQuad(A first, B second, C third, D fourth)
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
	 */
	@Override
	public A setFirst(A first)
	{
		return setKey(first);
	}

	/**
	 * Get the current <em>first</em> element value.
	 *
	 * @return The current <em>first</em> element value.
	 */
	@Override
	public A getFirst()
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
	 */
	@Override
	public B setSecond(B second)
	{
		return setValue(second);
	}

	/**
	 * Get the current <em>second</em> element value.
	 *
	 * @return The current <em>second</em> element value.
	 */
	@Override
	public B getSecond()
	{
		return getValue();
	}

	/**
	 * Set the <em>third</em> element value.
	 *
	 * @param third The new <em>third</em> element value.
	 * @return The old <em>third</em> element value.
	 * @see Triple#setRight(Object)
	 */
	@Override
	public C setThird(C third)
	{
		return setRight(third);
	}

	/**
	 * Get the current <em>third</em> element value.
	 *
	 * @return The current <em>third</em> element value.
	 */
	@Override
	public C getThird()
	{
		return getRight();
	}

	/**
	 * Set the <em>fourth</em> element value.
	 *
	 * @param fourth The new <em>fourth</em> element value.
	 * @return The old <em>fourth</em> element value.
	 */
	@Override
	public D setFourth(D fourth)
	{
		D oldFourth = this.fourth;
		this.fourth = fourth;
		return oldFourth;
	}

	/**
	 * Get the current <em>fourth</em> element value.
	 *
	 * @return The current <em>fourth</em> element value.
	 */
	@Override
	public D getFourth()
	{
		return fourth;
	}
}
