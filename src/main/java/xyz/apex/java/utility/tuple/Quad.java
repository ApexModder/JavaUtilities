package xyz.apex.java.utility.tuple;

import xyz.apex.java.utility.immutable.ImmutableQuad;
import xyz.apex.java.utility.mutable.MutableQuad;

/**
 * Object containing 4 elements of differing types.
 *
 * @param <A> The base object type for the <em>key/left/first</em> element.
 * @param <B> The base object type for the <em>value/middle/second</em> element.
 * @param <C> The base object type for the <em>third</em> element.
 * @see Pair
 * @see Triple
 */
public interface Quad<A, B, C, D> extends Triple<A, B, C>
{
	/**
	 * Set the <em>first</em> element value.
	 *
	 * @param first The new <em>first</em> element value.
	 * @return The old <em>first</em> element value.
	 * @see Pair#setKey(Object)
	 * @see Triple#setLeft(Object)
	 */
	A setFirst(A first);

	/**
	 * Set the <em>first</em> element value.
	 *
	 * @param first The new <em>first</em> element value.
	 * @return The old <em>first</em> element value.
	 * @see Pair#setKey(Object)
	 * @see Triple#setLeft(Object)
	 * @see #setFirst(Object)
	 */
	@Override A setLeft(A first);

	/**
	 * Set the <em>first</em> element value.
	 *
	 * @param first The new <em>first</em> element value.
	 * @return The old <em>first</em> element value.
	 * @see Pair#setKey(Object)
	 * @see Triple#setLeft(Object)
	 * @see #setFirst(Object)
	 */
	@Override A setKey(A first);

	/**
	 * Get the current <em>first</em> element value.
	 *
	 * @return The current <em>first</em> element value.
	 */
	A getFirst();

	/**
	 * Get the current <em>first</em> element value.
	 *
	 * @return The current <em>first</em> element value.
	 * @see Pair#getKey()
	 * @see Triple#getLeft()
	 * @see #getFirst()
	 */
	@Override A getLeft();

	/**
	 * Get the current <em>first</em> element value.
	 *
	 * @return The current <em>first</em> element value.
	 * @see Pair#getKey()
	 * @see Triple#getLeft()
	 * @see #getFirst()
	 */
	@Override A getKey();

	/**
	 * Set the <em>second</em> element value.
	 *
	 * @param second The new <em>second</em> element value.
	 * @return The old <em>second</em> element value.
	 * @see Pair#setValue(Object)
	 * @see Triple#setMiddle(Object)
	 */
	B setSecond(B second);

	/**
	 * Set the <em>second</em> element value.
	 *
	 * @param second The new <em>second</em> element value.
	 * @return The old <em>second</em> element value.
	 * @see Pair#setValue(Object)
	 * @see Triple#setMiddle(Object)
	 * @see #setSecond(Object)
	 */
	@Override B setMiddle(B second);

	/**
	 * Set the <em>second</em> element value.
	 *
	 * @param second The new <em>second</em> element value.
	 * @return The old <em>second</em> element value.
	 * @see Pair#setValue(Object)
	 * @see Triple#setMiddle(Object)
	 * @see #setSecond(Object)
	 */
	@Override B setValue(B second);

	/**
	 * Get the current <em>second</em> element value.
	 *
	 * @return The current <em>second</em> element value.
	 */
	B getSecond();

	/**
	 * Get the current <em>second</em> element value.
	 *
	 * @return The current <em>second</em> element value.
	 * @see Pair#getValue()
	 * @see Triple#getMiddle()
	 * @see #getSecond()
	 */
	@Override B getMiddle();

	/**
	 * Get the current <em>second</em> element value.
	 *
	 * @return The current <em>second</em> element value.
	 * @see Pair#getValue()
	 * @see Triple#getMiddle()
	 * @see #getSecond()
	 */
	@Override B getValue();

	/**
	 * Set the <em>third</em> element value.
	 *
	 * @param third The new <em>third</em> element value.
	 * @return The old <em>third</em> element value.
	 * @see Triple#setRight(Object)
	 */
	C setThird(C third);

	/**
	 * Set the <em>third</em> element value.
	 *
	 * @param third The new <em>third</em> element value.
	 * @return The old <em>third</em> element value.
	 * @see Triple#setRight(Object)
	 * @see #setThird(Object)
	 */
	@Override C setRight(C third);

	/**
	 * Get the current <em>third</em> element value.
	 *
	 * @return The current <em>third</em> element value.
	 */
	C getThird();

	/**
	 * Get the current <em>third</em> element value.
	 *
	 * @return The current <em>third</em> element value.
	 * @see Triple#getRight()
	 * @see #getThird()
	 */
	@Override C getRight();

	/**
	 * Set the <em>fourth</em> element value.
	 *
	 * @param fourth The new <em>fourth</em> element value.
	 * @return The old <em>fourth</em> element value.
	 */
	D setFourth(D fourth);

	/**
	 * Get the current <em>fourth</em> element value.
	 *
	 * @return The current <em>fourth</em> element value.
	 */
	D getFourth();

	/**
	 * Creates a new {@link Quad} from the given <em>first, second, third, fourth</em> elements.
	 *
	 * @param first The <em>first</em> element of the built {@link Quad}.
	 * @param second The <em>second</em> element of the built {@link Quad}.
	 * @param third The <em>third</em> element of the built {@link Quad}.
	 * @param fourth The <em>fourth</em> element of the built {@link Quad}.
	 * @param <A> The base object type for the <em>first</em> element.
	 * @param <B> The base object type for the <em>second</em> element.
	 * @param <C> The base object type for the <em>third</em> element.
	 * @param <D> The base object type for the <em>fourth</em> element.
	 * @return {@link Triple} built from the given <em>first, second, third, fourth</em> elements.
	 * @see MutableQuad
	 */
	static <A, B, C, D> Quad<A, B, C, D> create(A first, B second, C third, D fourth)
	{
		return new MutableQuad<>(first, second, third, fourth);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Quad} from the given <em>first, second, third, fourth</em> elements.
	 *
	 * @param first The <em>first</em> element of the built {@link Quad}.
	 * @param second The <em>second</em> element of the built {@link Quad}.
	 * @param third The <em>third</em> element of the built {@link Quad}.
	 * @param fourth The <em>fourth</em> element of the built {@link Quad}.
	 * @param <A> The base object type for the <em>first</em> element.
	 * @param <B> The base object type for the <em>second</em> element.
	 * @param <C> The base object type for the <em>third</em> element.
	 * @param <D> The base object type for the <em>fourth</em> element.
	 * @return {@link Quad} built from the given <em>first, second, third, fourth</em> elements.
	 * @see ImmutableQuad
	 */
	static <A, B, C, D> Quad<A, B, C, D> createImmutable(A first, B second, C third, D fourth)
	{
		return new ImmutableQuad<>(first, second, third, fourth);
	}
}
