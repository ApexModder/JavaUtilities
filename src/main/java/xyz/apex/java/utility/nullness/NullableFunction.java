package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link Function} where the input and result can be nullable
 *
 * @param <T> The type of the input to the operation
 * @param <R> The type of the result of the function
 *
 * @see Function
 * @see Nullable
 */
@FunctionalInterface
public interface NullableFunction<@NullableType T, @NullableType R> extends Function<T, R>
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
	default <@NullableType V> NullableFunction<V, R> compose(NullableFunction<? super V, ? extends T> before)
	{
		Objects.requireNonNull(before);
		return v -> apply(before.apply(v));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Function#andThen(Function)
	 */
	default <@NullableType V> NullableFunction<T, V> andThen(NullableFunction<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @param <T> the type of the input and output objects to the function
	 * @return a function that always returns its input argument
	 *
	 * @see Function#identity()
	 */
	static <@NullableType T> NullableFunction<T, T> identity()
	{
		return t -> t;
	}
}
