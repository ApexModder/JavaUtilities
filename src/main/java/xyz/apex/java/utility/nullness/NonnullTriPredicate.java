package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.TriPredicate;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An alternative to {@link TriPredicate} where the inputs must always be nonnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriPredicate
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullTriPredicate<@NonnullType A, @NonnullType B, @NonnullType C> extends TriPredicate<A, B, C>, NonnullTriFunction<A, B, C, Boolean>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean test(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(A a, B b, C c)
	{
		return test(a, b, c);
	}

	/**
	 * @see TriPredicate#and(TriPredicate)
	 */
	default NonnullTriPredicate<A, B, C> and(NonnullTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}

	/**
	 * @see TriPredicate#negate()
	 */
	default NonnullTriPredicate<A, B, C> negate()
	{
		return (a, b, c) -> !test(a, b, c);
	}

	/**
	 * @see TriPredicate#or(TriPredicate)
	 */
	default NonnullTriPredicate<A, B, C> or(NonnullTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}
