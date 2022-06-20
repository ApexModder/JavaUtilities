package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * An alternative to {@link Supplier} which result can be nullable.
 *
 * @param <T> The type of results supplied by this supplier
 *
 * @see Supplier
 * @see Nullable
 */
@FunctionalInterface
public interface NullableSupplier<@NullableType T> extends Supplier<T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Supplier#get()
	 */
	@Override
	T get();

	/**
	 * Gets a result, throws an exception if {@code null} is returned.
	 *
	 * @return a result, throws an exception if {@code null} is returned.
	 * @throws NullPointerException if result is {@code null}
	 */
	default T getNotNull()
	{
		return getNotNull(() -> "Unexpected null value from supplier");
	}

	/**
	 * Gets a result, throws an exception if {@code null} is returned.
	 *
	 * @param errorMessage message passed to thrown exception if result is {@code null}
	 * @return a result, throws an exception if {@code null} is returned.
	 * @throws NullPointerException if result is {@code null}
	 */
	default T getNotNull(NotNullSupplier<String> errorMessage)
	{
		return Objects.requireNonNull(get(), errorMessage);
	}

	/**
	 * Converts this nullable supplier into a notnull-able supplier
	 *
	 * @return a notnull-able supplier
	 * @throws NullPointerException if result of supplier is ever {@code null}
	 */
	default NotNullSupplier<T> asNotNull()
	{
		return this::getNotNull;
	}

	/**
	 * Converts this nullable supplier into a notnull-able supplier
	 *
	 * @param errorMessage messaged passed to thrown exception if result is {@code null}
	 * @return a notnull-able supplier
	 * @throws NullPointerException if result of supplier is ever {@code null}
	 */
	default NotNullSupplier<T> asNotNull(NotNullSupplier<String> errorMessage)
	{
		return () -> getNotNull(errorMessage);
	}
}
