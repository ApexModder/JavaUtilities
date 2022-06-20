package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * An alternative to {@link BiPredicate} where the inputs must always be notnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiPredicate
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullBiPredicate<@NotNullType T, @NotNullType U> extends BiPredicate<T, U>, NotNullBiFunction<T, U, Boolean>
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
	default NotNullBiPredicate<T, U> and(NotNullBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) && other.test(t, u);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see BiPredicate#or(BiPredicate)
	 */
	default NotNullBiPredicate<T, U> or(NotNullBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) || other.test(t, u);
	}
}
