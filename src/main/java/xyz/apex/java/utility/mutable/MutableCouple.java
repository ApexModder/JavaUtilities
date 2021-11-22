package xyz.apex.java.utility.mutable;

import xyz.apex.java.utility.tuple.Couple;
import xyz.apex.java.utility.tuple.Pair;

/**
 * Pair of 2 objects which have the same base type.
 * <br>
 * This object is <b>Mutable</b>, this means all elements <b>can</b> be modified with no side effects.
 *
 * @param <T> The base object type for both the <em>key {@literal &} value</em> elements.
 * @see Pair
 * @see Couple
 * @since 1.0.1-J8
 */
public class MutableCouple<T> extends MutablePair<T, T> implements Couple<T>
{
	public MutableCouple(T key, T value)
	{
		super(key, value);
	}

	public MutableCouple(T value)
	{
		this(value, value);
	}
}
