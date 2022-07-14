package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import xyz.apex.java.utility.api.function.QuadFunction;

import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link QuadFunction} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadFunction
 * @see Nullable
 */
@FunctionalInterface
public interface NullableQuadFunction<@NullableType A, @NullableType B, @NullableType C, @NullableType D, @NullableType R> extends QuadFunction<A, B, C, D, R>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see QuadFunction#apply(Object, Object, Object, Object)
	 */
	@Override
	R apply(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadFunction#andThen(Function)
	 */
	default <@NullableType V> NullableQuadFunction<A, B, C, D, V> andThen(Function<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c, d) -> after.apply(apply(a, b, c, d));
	}
}