package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * An alternative to {@link BiConsumer} where the inputs must always be nonnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiConsumer
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullBiConsumer<@NonnullType T, @NonnullType U> extends BiConsumer<T, U>
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
	default NonnullBiConsumer<T, U> andThen(NonnullBiConsumer<? super T, ? super U> after)
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
	static <@NonnullType T, @NonnullType U> NonnullBiConsumer<T, U> noop()
	{
		return (t, u) -> { };
	}
}
