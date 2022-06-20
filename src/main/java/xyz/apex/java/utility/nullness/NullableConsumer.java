package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * An alternative to {@link Consumer} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Consumer
 * @see Nullable
 */
@FunctionalInterface
public interface NullableConsumer<@NullableType T> extends Consumer<T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Consumer#accept(Object)
	 */
	@Override
	void accept(T t);

	/**
	 * {@inheritDoc}
	 *
	 * @see Consumer#andThen(Consumer)
	 */
	default NullableConsumer<T> andThen(NullableConsumer<? super T> after)
	{
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

	/**
	 * Builds consumer that does nothing when applied
	 *
	 * @param <T> The type of input to the operation
	 * @return Returns a consumer that does nothing when applied
	 */
	static <@NullableType T> NullableConsumer<T> noop()
	{
		return t -> { };
	}
}
