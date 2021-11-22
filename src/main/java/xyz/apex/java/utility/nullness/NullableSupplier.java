package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
public interface NullableSupplier<@NullableType T> extends Supplier<T>
{
	@Override
	T get();

	default T getNonnull()
	{
		return getNonnull(() -> "Unexpected null value from supplier");
	}

	default T getNonnull(NonnullSupplier<String> errorMessage)
	{
		return Objects.requireNonNull(get(), errorMessage);
	}

	default NonnullSupplier<T> asNonnull()
	{
		return this::getNonnull;
	}

	default NonnullSupplier<T> asNonnull(NonnullSupplier<String> errorMessage)
	{
		return () -> getNonnull(errorMessage);
	}
}
