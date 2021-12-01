package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.QuadFunction;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link QuadFunction} where the inputs must always be nonnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadFunction
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullQuadFunction<@NonnullType A, @NonnullType B, @NonnullType C, @NonnullType D, @NonnullType R> extends QuadFunction<A, B, C, D, R>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	R apply(A a, B b, C c, D d);

	/**
	 * @see QuadFunction#andThen(Function)
	 */
	default <@NonnullType V> NonnullQuadFunction<A, B, C, D, V> andThen(NonnullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c, d) -> after.apply(apply(a, b, c, d));
	}
}
