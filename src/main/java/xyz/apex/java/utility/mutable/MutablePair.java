package xyz.apex.java.utility.mutable;

import xyz.apex.java.utility.tuple.Pair;

/**
 * Pair of 2 objects which have differing base types.
 * <br>
 * This object is <b>Mutable</b>, this means all elements <b>can</b> be modified with no side effects.
 *
 * @param <K> The base object type for the <em>key</em> element.
 * @param <V> The base object type for the <em>value</em> element.
 * @see Pair
 */
public class MutablePair<K, V> implements Pair<K, V>
{
	public K key;
	public V value;

	public MutablePair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * Set the <em>key</em> element value.
	 *
	 * @param key The new <em>key</em> element value.
	 * @return The old <em>key</em> element value.
	 */
	@Override
	public K setKey(K key)
	{
		K oldKey = this.key;
		this.key = key;
		return oldKey;
	}

	/**
	 * Get the current <em>key</em> element value.
	 *
	 * @return The current <em>key</em> element value.
	 */
	@Override
	public K getKey()
	{
		return key;
	}

	/**
	 * Set the <em>value</em> element value.
	 *
	 * @param value The new <em>value</em> element value.
	 * @return The old <em>value</em> element value.
	 */
	@Override
	public V setValue(V value)
	{
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	/**
	 * Get the current <em>value</em> element value.
	 *
	 * @return The current <em>value</em> element value.
	 */
	@Override
	public V getValue()
	{
		return value;
	}
}
