package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link Function} where the input and result is must always be nonnull
 *
 * @param <T> The type of the input to the operation
 * @param <R> The type of the result of the function
 *
 * @see Function
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullFunction<@NonnullType T, @NonnullType R> extends Function<T, R>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	R apply(T t);

	/**
	 * @see Function#compose(Function)
	 */
	default <@NonnullType V> NonnullFunction<V, R> compose(NonnullFunction<? super V, ? extends T> before)
	{
		Objects.requireNonNull(before);
		return v -> apply(before.apply(v));
	}

	/**
	 * @see Function#andThen(Function)
	 */
	default <@NonnullType V> NonnullFunction<T, V> andThen(NonnullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @see Function#identity()
	 */
	static <@NonnullType T> NonnullFunction<T, T> identity()
	{
		return t -> t;
	}
}
