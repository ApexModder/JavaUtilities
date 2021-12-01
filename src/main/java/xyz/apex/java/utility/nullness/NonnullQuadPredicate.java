package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.QuadPredicate;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An alternative to {@link QuadPredicate} where the inputs must always be nonnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadPredicate
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullQuadPredicate<@NonnullType A, @NonnullType B, @NonnullType C, @NonnullType D> extends QuadPredicate<A, B, C, D>, NonnullQuadFunction<A, B, C, D, Boolean>
{
	/**
	 * {@inheritDoc}
	 */
	boolean test(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(A a, B b, C c, D d)
	{
		return test(a, b, c, d);
	}

	/**
	 * @see QuadPredicate#and(QuadPredicate)
	 */
	default NonnullQuadPredicate<A, B, C, D> and(NonnullQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) && other.test(a, b, c, d);
	}

	/**
	 * @see QuadPredicate#negate()
	 */
	default NonnullQuadPredicate<A, B, C, D> negate()
	{
		return (a, b, c, d) -> !test(a, b, c, d);
	}

	/**
	 * @see QuadPredicate#or(QuadPredicate)
	 */
	default NonnullQuadPredicate<A, B, C, D> or(NonnullQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) || other.test(a, b, c, d);
	}
}
