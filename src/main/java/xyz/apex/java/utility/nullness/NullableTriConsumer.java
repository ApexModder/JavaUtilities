package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.TriConsumer;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * An alternative to {@link TriConsumer} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriConsumer
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableTriConsumer<@NullableType A, @NullableType B, @NullableType C> extends TriConsumer<A, B, C>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	void accept(A a, B b, C c);

	/**
	 * @see TriConsumer#andThen(TriConsumer)
	 */
	default NullableTriConsumer<A, B, C> andThen(NullableTriConsumer<? super A, ? super B, ? super C> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c) -> {
			accept(a, b, c);
			after.accept(a, b, c);
		};
	}

	/**
	 * @see TriConsumer#noop()
	 */
	static <@NullableType A, @NullableType B, @NullableType C> NullableTriConsumer<A, B, C> noop()
	{
		return (a, b, c) -> { };
	}
}
