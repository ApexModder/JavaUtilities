package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * An alternative to {@link Consumer} where the input is must always be notnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Consumer
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullConsumer<@NotNullType T> extends Consumer<T>
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
	default NotNullConsumer<T> andThen(NotNullConsumer<? super T> after)
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
	static <@NotNullType T> NotNullConsumer<T> noop()
	{
		return t -> { };
	}
}