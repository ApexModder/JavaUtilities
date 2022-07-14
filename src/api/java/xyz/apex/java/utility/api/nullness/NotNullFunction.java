package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link Function} where the input and result is must always be notnull
 *
 * @param <T> The type of the input to the operation
 * @param <R> The type of the result of the function
 *
 * @see Function
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullFunction<@NotNullType T, @NotNullType R> extends Function<T, R>
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
	default <@NotNullType V> NotNullFunction<V, R> compose(NotNullFunction<? super V, ? extends T> before)
	{
		Objects.requireNonNull(before);
		return v -> apply(before.apply(v));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Function#andThen(Function)
	 */
	default <@NotNullType V> NotNullFunction<T, V> andThen(NotNullFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @param <T> the type of the input and output objects to the function
	 * @return a function that always returns its input argument
	 * @see Function#identity()
	 */
	static <@NotNullType T> NotNullFunction<T, T> identity()
	{
		return t -> t;
	}
}