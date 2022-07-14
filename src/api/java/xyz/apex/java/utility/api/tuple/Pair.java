package xyz.apex.java.utility.api.tuple;

import xyz.apex.java.utility.api.JavaUtilities;

/**
 * Pair of 2 objects which have differing base types.
 *
 * @param <K> The base object type for the <em>key</em> element.
 * @param <V> The base object type for the <em>value</em> element.
 */
public interface Pair<K, V>
{
	/**
	 * Set the <em>key</em> element value.
	 *
	 * @param key The new <em>key</em> element value.
	 * @return The old <em>key</em> element value.
	 */
	K setKey(K key);

	/**
	 * Get the current <em>key</em> element value.
	 *
	 * @return The current <em>key</em> element value.
	 */
	K getKey();

	/**
	 * Set the <em>value</em> element value.
	 *
	 * @param value The new <em>value</em> element value.
	 * @return The old <em>value</em> element value.
	 */
	V setValue(V value);

	/**
	 * Get the current <em>value</em> element value.
	 *
	 * @return The current <em>value</em> element value.
	 */
	V getValue();

	/**
	 * Creates a new {@link Pair} from the given <em>key, value</em> elements.
	 *
	 * @param key The <em>key</em> element of the built {@link Pair}.
	 * @param value The <em>value</em> element of the built {@link Pair}.
	 * @param <K> The base object type for the <em>key</em> element.
	 * @param <V> The base object type for the <em>value</em> element.
	 * @return {@link Pair} built from the given <em>key, value</em> elements.
	 */
	static <K, V> Pair<K, V> create(K key, V value)
	{
		return JavaUtilities.INSTANCE.createMutablePair(key, value);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Pair} from the given <em>key, value</em> elements.
	 *
	 * @param key The <em>key</em> element of the built {@link Pair}.
	 * @param value The <em>value</em> element of the built {@link Pair}.
	 * @param <K> The base object type for the <em>key</em> element.
	 * @param <V> The base object type for the <em>value</em> element.
	 * @return {@link Pair} built from the given <em>key, value</em> elements.
	 */
	static <K, V> Pair<K, V> createImmutable(K key, V value)
	{
		return JavaUtilities.INSTANCE.createImmutablePair(key, value);
	}
}