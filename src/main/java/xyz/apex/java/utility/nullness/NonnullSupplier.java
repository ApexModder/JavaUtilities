package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * An alternative to {@link Supplier} which always returns a nonnull result.
 *
 * @param <T> The type of results supplied by this supplier
 *
 * @see Supplier
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullSupplier<@NonnullType T> extends Supplier<T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Supplier#get()
	 */
	@Override
	T get();

	/**
	 * Builds a supplier where an exception is thrown if the result is null
	 *
	 * @param supplier Supplier to be made nonnull
	 * @param <T> The type of results supplied by this supplier
	 * @return The newly built nonnull supplier
	 * @since 1.0.0-J8
	 */
	static <@NullableType T> NonnullSupplier<T> of(Supplier<T> supplier)
	{
		return of(supplier, () -> "Unexpected null value from supplier");
	}

	/**
	 * Builds a supplier where an exception is thrown if the result is null (with the specified error message)
	 *
	 * @param supplier Supplier to be made nonnull
	 * @param errorMessage error message to the passed to exception if the result is null
	 * @param <T> The type of results supplied by this supplier
	 * @return The newly built nonnull supplier
	 * @since 1.0.0-J8
	 */
	static <@NullableType T> NonnullSupplier<T> of(Supplier<T> supplier, NonnullSupplier<String> errorMessage)
	{
		return () -> Objects.requireNonNull(supplier.get(), errorMessage);
	}
}
