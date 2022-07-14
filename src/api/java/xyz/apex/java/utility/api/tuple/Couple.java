package xyz.apex.java.utility.api.tuple;

import xyz.apex.java.utility.api.JavaUtilities;

/**
 * Pair of 2 objects which have the same base type.
 *
 * @param <T> The base object type for both the <em>key {@literal &} value</em> elements.
 * @see Pair
 */
public interface Couple<T> extends Pair<T, T>
{
	/**
	 * Set the <em>key</em> element value.
	 *
	 * @param key The new <em>key</em> element value.
	 * @return The old <em>key</em> element value.
	 * @see Pair#setKey(Object)
	 */
	@Override T setKey(T key);

	/**
	 * Get the current <em>key</em> element value.
	 *
	 * @return The current <em>key</em> element value.
	 * @see Pair#getKey()
	 */
	@Override T getKey();

	/**
	 * Set the <em>value</em> element value.
	 *
	 * @param value The new <em>value</em> element value.
	 * @return The old <em>value</em> element value.
	 * @see Pair#setValue(Object)
	 */
	@Override T setValue(T value);

	/**
	 * Get the current <em>value</em> element value.
	 *
	 * @return The current <em>value</em> element value.
	 * @see Pair#getValue()
	 */
	@Override T getValue();

	/**
	 * Creates a new {@link Couple} from the given <em>key, value</em> elements.
	 *
	 * @param key The <em>key</em> element of the built {@link Couple}.
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 */
	static <T> Couple<T> create(T key, T value)
	{
		return JavaUtilities.INSTANCE.createMutableCouple(key, value);
	}

	/**
	 * Creates a new {@link Couple} where the given <em>value</em> element is both the <em>key {@literal &} value</em> elements.
	 *
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 * @see #create(Object, Object)
	 */
	static <T> Couple<T> create(T value)
	{
		return create(value, value);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Couple} from the given <em>key, value</em> elements.
	 *
	 * @param key The <em>key</em> element of the built {@link Couple}.
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 */
	static <T> Couple<T> createImmutable(T key, T value)
	{
		return JavaUtilities.INSTANCE.createImmutableCouple(key, value);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Couple} where the given <em>value</em> element is both the <em>key {@literal &} value</em> elements.
	 *
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 * @see #createImmutable(Object, Object)
	 */
	static <T> Couple<T> createImmutable(T value)
	{
		return createImmutable(value, value);
	}
}