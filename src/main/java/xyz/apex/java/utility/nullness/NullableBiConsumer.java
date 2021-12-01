package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * An alternative to {@link BiConsumer} where the inputs can be nullable
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiConsumer
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableBiConsumer<@NullableType T, @NullableType U> extends BiConsumer<T, U>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see BiConsumer#accept(Object, Object)
	 */
	@Override
	void accept(T t, U u);

	/**
	 * {@inheritDoc}
	 *
	 * @see BiConsumer#andThen(BiConsumer)
	 */
	default NullableBiConsumer<T, U> andThen(NullableBiConsumer<? super T, ? super U> after)
	{
		Objects.requireNonNull(after);
		return (t, u) -> {
			accept(t, u);
			after.accept(t, u);
		};
	}

	/**
	 * Builds consumer that does nothing when applied
	 *
	 * @param <T> The type of first argument to the operation
	 * @param <U> The type of second argument to the operation
	 *
	 * @return Returns a consumer that does nothing when applied
	 * @since 1.0.0-J8
	 */
	static <@NullableType T, @NullableType U> NullableBiConsumer<T, U> noop()
	{
		return (t, u) -> { };
	}
}
