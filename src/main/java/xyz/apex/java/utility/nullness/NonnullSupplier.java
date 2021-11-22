package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
public interface NonnullSupplier<@NonnullType T> extends Supplier<T>
{
	@Override
	T get();

	static <@NullableType T> NonnullSupplier<T> of(Supplier<T> supplier)
	{
		return of(supplier, () -> "Unexpected null value from supplier");
	}

	static <@NullableType T> NonnullSupplier<T> of(Supplier<T> supplier, NonnullSupplier<String> errorMessage)
	{
		return () -> Objects.requireNonNull(supplier.get(), errorMessage);
	}
}
