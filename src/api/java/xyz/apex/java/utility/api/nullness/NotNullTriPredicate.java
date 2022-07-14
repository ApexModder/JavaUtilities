package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import xyz.apex.java.utility.api.function.TriPredicate;

import java.util.Objects;

/**
 * An alternative to {@link TriPredicate} where the inputs must always be notnull
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriPredicate
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullTriPredicate<@NotNullType A, @NotNullType B, @NotNullType C> extends TriPredicate<A, B, C>, NotNullTriFunction<A, B, C, Boolean>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#test(Object, Object, Object)
	 */
	@Override
	boolean test(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#apply(Object, Object, Object)
	 */
	@Override
	default Boolean apply(A a, B b, C c)
	{
		return test(a, b, c);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#and(TriPredicate)
	 */
	default NotNullTriPredicate<A, B, C> and(NotNullTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#negate()
	 */
	default NotNullTriPredicate<A, B, C> negate()
	{
		return (a, b, c) -> !test(a, b, c);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#or(TriPredicate)
	 */
	default NotNullTriPredicate<A, B, C> or(NotNullTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}