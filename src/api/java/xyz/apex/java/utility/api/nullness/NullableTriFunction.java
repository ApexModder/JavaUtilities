package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import xyz.apex.java.utility.api.function.TriFunction;

import java.util.Objects;
import java.util.function.Function;

/**
 * An alternative to {@link TriFunction} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriFunction
 * @see Nullable
 */
@NullableType
public interface NullableTriFunction<@NullableType A, @NullableType B, @NullableType C, @NullableType R> extends TriFunction<A, B, C, R>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see TriFunction#apply(Object, Object, Object)
	 */
	@Override
	R apply(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 *
	 * @see TriFunction#andThen(Function)
	 */
	default <@NullableType V> NullableTriFunction<A, B, C, V> andThen(Function<? super R, ? extends V> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c) -> after.apply(apply(a, b, c));
	}
}