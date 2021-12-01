package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * An alternative to {@link BiPredicate} where the inputs can be nullable
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiPredicate
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableBiPredicate<@NullableType T, @NullableType U> extends BiPredicate<T, U>, NullableBiFunction<T, U, Boolean>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see BiPredicate#test(Object, Object)
	 */
	@Override
	boolean test(T t, U u);

	/**
	 * {@inheritDoc}
	 *
	 * @see BiFunction#apply(Object, Object)
	 */
	@Override
	default Boolean apply(T t, U u)
	{
		return test(t, u);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see BiPredicate#and(BiPredicate)
	 */
	default NullableBiPredicate<T, U> and(NullableBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) && other.test(t, u);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see BiPredicate#or(BiPredicate)
	 */
	default NullableBiPredicate<T, U> or(NullableBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) || other.test(t, u);
	}
}
