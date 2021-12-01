package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.QuadConsumer;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * An alternative to {@link QuadConsumer} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the fourth argument to the operation
 *
 * @see QuadConsumer
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableQuadConsumer<@NullableType A, @NullableType B, @NullableType C, @NullableType D> extends QuadConsumer<A, B, C, D>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see QuadConsumer#accept(Object, Object, Object, Object)
	 */
	@Override
	void accept(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadConsumer#andThen(QuadConsumer)
	 */
	default NullableQuadConsumer<A, B, C, D> andThen(NullableQuadConsumer<? super A, ? super B, ? super C, ? super D> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c, d) -> {
			accept(a, b, c, d);
			after.accept(a, b, c, d);
		};
	}

	/**
	 * @param <A> The type of first argument to the operation
	 * @param <B> The type of second argument to the operation
	 * @param <C> The type of third argument to the operation
	 * @param <D> The type of fourth argument to the operation
	 * @return Returns a consumer that does nothing when applied
	 *
	 * @see QuadConsumer#noop()
	 */
	static <@NullableType A, @NullableType B, @NullableType C, @NullableType D> NullableQuadConsumer<A, B, C, D> noop()
	{
		return (a, b, c, d) -> { };
	}
}
