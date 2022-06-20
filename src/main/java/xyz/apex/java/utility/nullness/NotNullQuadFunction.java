package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.NotNull;

import xyz.apex.java.utility.function.QuadFunction;

import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link QuadFunction} where the inputs must always be notnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadFunction
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullQuadFunction<@NotNullType A, @NotNullType B, @NotNullType C, @NotNullType D, @NotNullType R> extends QuadFunction<A, B, C, D, R>
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
	default <@NotNullType V> NotNullQuadFunction<A, B, C, D, V> andThen(NotNullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c, d) -> after.apply(apply(a, b, c, d));
	}
}
