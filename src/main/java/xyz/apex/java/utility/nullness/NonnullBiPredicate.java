package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * An alternative to {@link BiPredicate} where the inputs must always be nonnull
 *
 * @param <T> The type of the first argument to the operation
 * @param <U> The type of the second argument to the operation
 *
 * @see BiPredicate
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullBiPredicate<@NonnullType T, @NonnullType U> extends BiPredicate<T, U>, NonnullBiFunction<T, U, Boolean>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean test(T t, U u);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(T t, U u)
	{
		return test(t, u);
	}

	/**
	 * @see BiPredicate#and(BiPredicate)
	 */
	default NonnullBiPredicate<T, U> and(NonnullBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) && other.test(t, u);
	}

	/**
	 * @see BiPredicate#or(BiPredicate)
	 */
	default NonnullBiPredicate<T, U> or(NonnullBiPredicate<? super T, ? super U> other)
	{
		Objects.requireNonNull(other);
		return (t, u) -> test(t, u) || other.test(t, u);
	}
}
