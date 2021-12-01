package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * An alternative to {@link Supplier} which result can be nullable.
 *
 * @param <T> The type of results supplied by this supplier
 *
 * @see Supplier
 * @see Nullable
 * @since 1.0.0-J8
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
	 * @since 1.0.0-J8
	 */
	default T getNonnull()
	{
		return getNonnull(() -> "Unexpected null value from supplier");
	}

	/**
	 * Gets a result, throws an exception if {@code null} is returned.
	 *
	 * @param errorMessage message passed to thrown exception if result is {@code null}
	 * @return a result, throws an exception if {@code null} is returned.
	 * @throws NullPointerException if result is {@code null}
	 * @since 1.0.0-J8
	 */
	default T getNonnull(NonnullSupplier<String> errorMessage)
	{
		return Objects.requireNonNull(get(), errorMessage);
	}

	/**
	 * Converts this nullable supplier into a nonnull-able supplier
	 *
	 * @return a nonnull-able supplier
	 * @throws NullPointerException if result of supplier is ever {@code null}
	 * @since 1.0.0-J8
	 */
	default NonnullSupplier<T> asNonnull()
	{
		return this::getNonnull;
	}

	/**
	 * Converts this nullable supplier into a nonnull-able supplier
	 *
	 * @param errorMessage messaged passed to thrown exception if result is {@code null}
	 * @return a nonnull-able supplier
	 * @throws NullPointerException if result of supplier is ever {@code null}
	 * @since 1.0.0-J8
	 */
	default NonnullSupplier<T> asNonnull(NonnullSupplier<String> errorMessage)
	{
		return () -> getNonnull(errorMessage);
	}
}
