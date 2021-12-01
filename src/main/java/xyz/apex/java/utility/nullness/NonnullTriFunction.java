package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.TriFunction;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link TriFunction} where the inputs must always be nonnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriFunction
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullTriFunction<@NonnullType A, @NonnullType B, @NonnullType C, @NonnullType R> extends TriFunction<A, B, C, R>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	R apply(A a, B b, C c);

	/**
	 * @see TriFunction#andThen(Function)
	 */
	default <@NonnullType V> NonnullTriFunction<A, B, C, V> andThen(NonnullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c) -> after.apply(apply(a, b, c));
	}
}
