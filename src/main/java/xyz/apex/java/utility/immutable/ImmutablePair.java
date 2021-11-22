package xyz.apex.java.utility.immutable;

import xyz.apex.java.utility.tuple.Pair;

/**
 * Pair of 2 objects which have differing base types.
 * <br>
 * This object is <b>Immutable</b>, this means all elements can <b>not</b> be modified.
 * <br>
 * All <em>setter</em> methods will throw {@link UnsupportedOperationException} if called.
 *
 * @param <K> The base object type for the <em>key</em> element.
 * @param <V> The base object type for the <em>value</em> element.
 * @see Pair
 * @since 1.0.1-J8
 */
public class ImmutablePair<K, V> implements Pair<K, V>
{
	public final K key;
	public final V value;

	public ImmutablePair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * Set the <em>key</em> element value.
	 *
	 * @param key The new <em>key</em> element value.
	 * @return The old <em>key</em> element value.
	 * @since 1.0.1-J8
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final K setKey(K key)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>key</em> element value.
	 *
	 * @return The current <em>key</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public final K getKey()
	{
		return key;
	}

	/**
	 * Set the <em>value</em> element value.
	 *
	 * @param value The new <em>value</em> element value.
	 * @return The old <em>value</em> element value.
	 * @since 1.0.1-J8
	 * @throws UnsupportedOperationException Object is immutable, elements can not be modified
	 */
	@Override
	public final V setValue(V value)
	{
		throw new UnsupportedOperationException("Object is immutable, elements can not be modified");
	}

	/**
	 * Get the current <em>value</em> element value.
	 *
	 * @return The current <em>value</em> element value.
	 * @since 1.0.1-J8
	 */
	@Override
	public final V getValue()
	{
		return value;
	}
}
