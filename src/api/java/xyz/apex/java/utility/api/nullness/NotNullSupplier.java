package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * An alternative to {@link Supplier} which always returns a notnull result.
 *
 * @param <T> The type of results supplied by this supplier
 *
 * @see Supplier
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullSupplier<@NotNullType T> extends Supplier<T>
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
	 * @param supplier Supplier to be made notnull
	 * @param <T> The type of results supplied by this supplier
	 * @return The newly built notnull supplier
	 */
	static <@NullableType T> NotNullSupplier<T> of(Supplier<T> supplier)
	{
		return of(supplier, () -> "Unexpected null value from supplier");
	}

	/**
	 * Builds a supplier where an exception is thrown if the result is null (with the specified error message)
	 *
	 * @param supplier Supplier to be made notnull
	 * @param errorMessage error message to the passed to exception if the result is null
	 * @param <T> The type of results supplied by this supplier
	 * @return The newly built notnull supplier
	 */
	static <@NullableType T> NotNullSupplier<T> of(Supplier<T> supplier, NotNullSupplier<String> errorMessage)
	{
		return () -> Objects.requireNonNull(supplier.get(), errorMessage);
	}
}