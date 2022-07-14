package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import xyz.apex.java.utility.api.function.TriConsumer;

import java.util.Objects;

/**
 * An alternative to {@link TriConsumer} where the inputs must always be notnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriConsumer
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullTriConsumer<@NotNullType A, @NotNullType B, @NotNullType C> extends TriConsumer<A, B, C>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see TriConsumer#accept(Object, Object, Object)
	 */
	@Override
	void accept(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 *
	 * @see TriConsumer#andThen(TriConsumer)
	 */
	default NotNullTriConsumer<A, B, C> andThen(NotNullTriConsumer<? super A, ? super B, ? super C> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c) -> {
			accept(a, b, c);
			after.accept(a, b, c);
		};
	}

	/**
	 * @param <A> The type of first argument to the operation
	 * @param <B> The type of second argument to the operation
	 * @param <C> The type of third argument to the operation
	 * @return Returns a consumer that does nothing when applied
	 *
	 * @see TriConsumer#noop()
	 */
	static <@NotNullType A, @NotNullType B, @NotNullType C> NotNullTriConsumer<A, B, C> noop()
	{
		return (a, b, c) -> { };
	}
}