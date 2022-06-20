package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * An alternative to {@link BiConsumer} where the inputs must always be notnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiConsumer
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullBiConsumer<@NotNullType T, @NotNullType U> extends BiConsumer<T, U>
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
	default NotNullBiConsumer<T, U> andThen(NotNullBiConsumer<? super T, ? super U> after)
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
	 */
	static <@NotNullType T, @NotNullType U> NotNullBiConsumer<T, U> noop()
	{
		return (t, u) -> { };
	}
}
