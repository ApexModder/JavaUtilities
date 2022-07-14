package xyz.apex.java.utility.immutable;

import xyz.apex.java.utility.api.tuple.Couple;
import xyz.apex.java.utility.api.tuple.Pair;

/**
 * Pair of 2 objects which have the same base type.
 * <br>
 * This object is <b>Immutable</b>, this means all elements can <b>not</b> be modified.
 * <br>
 * All <em>setter</em> methods will throw {@link UnsupportedOperationException} if called.
 *
 * @param <T> The base object type for both the <em>key {@literal &} value</em> elements.
 * @see Pair
 * @see Couple
 */
public class ImmutableCouple<T> extends ImmutablePair<T, T> implements Couple<T>
{
	public ImmutableCouple(T key, T value)
	{
		super(key, value);
	}

	public ImmutableCouple(T value)
	{
		this(value, value);
	}
}