package xyz.apex.java.utility.tuple;

import xyz.apex.java.utility.immutable.ImmutableCouple;
import xyz.apex.java.utility.mutable.MutableCouple;

/**
 * Pair of 2 objects which have the same base type.
 *
 * @param <T> The base object type for both the <em>key & value</em> elements.
 * @see Pair
 * @since 1.0.1-J8
 */
public interface Couple<T> extends Pair<T, T>
{
	/**
	 * Set the <em>key</em> element value.
	 *
	 * @param key The new <em>key</em> element value.
	 * @return The old <em>key</em> element value.
	 * @see Pair#setKey(Object)
	 * @since 1.0.1-J8
	 */
	@Override T setKey(T key);

	/**
	 * Get the current <em>key</em> element value.
	 *
	 * @return The current <em>key</em> element value.
	 * @see Pair#getKey()
	 * @since 1.0.1-J8
	 */
	@Override T getKey();

	/**
	 * Set the <em>value</em> element value.
	 *
	 * @param value The new <em>value</em> element value.
	 * @return The old <em>value</em> element value.
	 * @see Pair#setValue(Object)
	 * @since 1.0.1-J8
	 */
	@Override T setValue(T value);

	/**
	 * Get the current <em>value</em> element value.
	 *
	 * @return The current <em>value</em> element value.
	 * @see Pair#getValue()
	 * @since 1.0.1-J8
	 */
	@Override T getValue();

	/**
	 * Creates a new {@link Couple} from the given <em>key, value</em> elements.
	 *
	 * @param key The <em>key</em> element of the built {@link Couple}.
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 * @see MutableCouple
	 * @since 1.0.1-J8
	 */
	static <T> Couple<T> create(T key, T value)
	{
		return new MutableCouple<>(key, value);
	}

	/**
	 * Creates a new {@link Couple} where the given <em>value</em> element is both the <em>key & value</em> elements.
	 *
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 * @see MutableCouple
	 * @see #create(Object, Object)
	 * @since 1.0.1-J8
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
	 * @see ImmutableCouple
	 * @since 1.0.1-J8
	 */
	static <T> Couple<T> createImmutable(T key, T value)
	{
		return new ImmutableCouple<>(key, value);
	}

	/**
	 * Creates a new <b>Immutable</b> {@link Couple} where the given <em>value</em> element is both the <em>key & value</em> elements.
	 *
	 * @param value The <em>value</em> element of the built {@link Couple}.
	 * @param <T> The base object type for the <em>key/value</em> element.
	 * @return {@link Couple} built from the given <em>key, value</em> elements.
	 * @see ImmutableCouple
	 * @see #createImmutable(Object, Object)
	 * @since 1.0.1-J8
	 */
	static <T> Couple<T> createImmutable(T value)
	{
		return createImmutable(value, value);
	}
}
