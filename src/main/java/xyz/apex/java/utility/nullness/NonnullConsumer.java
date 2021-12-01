package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * An alternative to {@link Consumer} where the input is must always be nonnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Consumer
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullConsumer<@NonnullType T> extends Consumer<T>
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
	default NonnullConsumer<T> andThen(NonnullConsumer<? super T> after)
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
	 * @since 1.0.0-J8
	 */
	static <@NonnullType T> NonnullConsumer<T> noop()
	{
		return t -> { };
	}
}
