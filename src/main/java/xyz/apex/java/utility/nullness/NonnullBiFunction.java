package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An alternative to {@link BiFunction} where the inputs must always be nonnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiFunction
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullBiFunction<@NonnullType T, @NonnullType U, @NonnullType R> extends BiFunction<T, U, R>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	R apply(T t, U u);

	/**
	 * @see BiFunction#andThen(Function)
	 */
	default <@NonnullType V> NonnullBiFunction<T, U, V> andThen(NonnullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (t, u) -> after.apply(apply(t, u));
	}
}
