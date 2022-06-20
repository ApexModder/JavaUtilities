package xyz.apex.java.utility.function;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Represents a predicate (boolean-valued function) of three arguments. This is
 * the three-arity specialization of {@link Predicate}.
 *
 * <p>This is a functional interface whose function method is {@link #test(Object, Object, Object)}
 *
 * @param <A> the type of the first argument to the predicate
 * @param <B> the type of the second argument to the predicate
 * @param <C> the type of the third argument to the predicate
 */
@FunctionalInterface
public interface TriPredicate<A, B, C> extends TriFunction<A, B, C, Boolean>
{
	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param a the first input argument
	 * @param b the second input argument
	 * @param c the third input argument
	 * @return {@code true} if the input arguments match the predicate,
	 * otherwise {@code false}
	 */
	boolean test(A a, B b, C c);

	/**
	 * Wrapper function to allow compatability with {@code TriFunction}<br>
	 *
	 * Wraps into {@link #test(Object, Object, Object)}
	 *
	 * @see TriFunction#apply(Object, Object, Object)
	 */
	@Override
	default Boolean apply(A a, B b, C c)
	{
		return test(a, b, c);
	}

	/**
	 * Returns a composed predicate that represents a short-circuiting logical
	 * AND of this predicate and another. When evaluating the composed
	 * predicate, if this predicate is {@code false}, then the {@code other}
	 * predicate is not evaluated.
	 *
	 * <p>Any exception thrown during evaluation of either predicate are relayed
	 * to the caller; if evaluation of this predicate throws an exception, the
	 * {@code other} predicate will not be evaluated.
	 *
	 * @param other a predicate that will be logically-ANDed with this
	 * predicate
	 * @return a composed predicate that represents the short-circuiting logical
	 * AND of this predicate and the {@code other} predicate
	 * @throws NullPointerException if other is null
	 */
	default TriPredicate<A, B, C> and(TriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}

	/**
	 * Returns a predicate that represents the logical negation of this
	 * predicate.
	 *
	 * @return a predicate that represents the logical negation of this
	 * predicate
	 */
	default TriPredicate<A, B, C> negate()
	{
		return (a, b, c) -> !test(a, b, c);
	}

	/**
	 * Returns a composed predicate that represents a short-circuiting logical
	 * OR of this predicate and another. When evaluating the composed
	 * predicate, if this predicate is {@code true}, then the {@code other}
	 * predicate is not evaluated.
	 *
	 * <p>Any exceptions thrown during evaluation of either predicate are relayed
	 * to the caller; if evaluation of this predicate throws an exception, the
	 * {@code other} predicate will not be evaluated.
	 *
	 * @param other a predicate that will be logically-ORed with this
	 * predicate
	 * @return a composed predicate that represents the short-circuiting logical
	 * OR of this predicate and the {@code other} predicate
	 * @throws NullPointerException if other is null
	 */
	default TriPredicate<A, B, C> or(TriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}
