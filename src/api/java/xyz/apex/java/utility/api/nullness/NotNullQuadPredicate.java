package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import xyz.apex.java.utility.api.function.QuadPredicate;

import java.util.Objects;

/**
 * An alternative to {@link QuadPredicate} where the inputs must always be notnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadPredicate
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullQuadPredicate<@NotNullType A, @NotNullType B, @NotNullType C, @NotNullType D> extends QuadPredicate<A, B, C, D>, NotNullQuadFunction<A, B, C, D, Boolean>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#test(Object, Object, Object, Object)
	 */
	boolean test(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#apply(Object, Object, Object, Object)
	 */
	@Override
	default Boolean apply(A a, B b, C c, D d)
	{
		return test(a, b, c, d);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#and(QuadPredicate)
	 */
	default NotNullQuadPredicate<A, B, C, D> and(NotNullQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) && other.test(a, b, c, d);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#negate()
	 */
	default NotNullQuadPredicate<A, B, C, D> negate()
	{
		return (a, b, c, d) -> !test(a, b, c, d);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#or(QuadPredicate)
	 */
	default NotNullQuadPredicate<A, B, C, D> or(NotNullQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) || other.test(a, b, c, d);
	}
}