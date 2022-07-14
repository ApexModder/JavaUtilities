package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An alternative to {@link BiFunction} where the inputs must always be notnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiFunction
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullBiFunction<@NotNullType T, @NotNullType U, @NotNullType R> extends BiFunction<T, U, R>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see BiFunction#apply(Object, Object)
	 */
	@Override
	R apply(T t, U u);

	/**
	 * {@inheritDoc}
	 *
	 * @see BiFunction#andThen(Function)
	 */
	default <@NotNullType V> NotNullBiFunction<T, U, V> andThen(NotNullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (t, u) -> after.apply(apply(t, u));
	}
}