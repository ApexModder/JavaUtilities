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
	 *
	 * @see Function#apply(Object)
	 */
	@Override
	R apply(T t);

	/**
	 * {@inheritDoc}
	 *
	 * @see Function#compose(Function)
	 */
	default <@NonnullType V> NonnullFunction<V, R> compose(NonnullFunction<? super V, ? extends T> before)
	{
		Objects.requireNonNull(before);
		return v -> apply(before.apply(v));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Function#andThen(Function)
	 */
	default <@NonnullType V> NonnullFunction<T, V> andThen(NonnullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @param <T> the type of the input and output objects to the function
	 * @return a function that always returns its input argument
	 * @see Function#identity()
	 */
	static <@NonnullType T> NonnullFunction<T, T> identity()
	{
		return t -> t;
	}
}
