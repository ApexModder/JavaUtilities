package xyz.apex.java.utility.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a function that accepts four arguments and produces a result.
 * This is the four-arity specialization of {@link Function}.
 *
 * <p>This is a functional interface whose method is {@link #apply(Object, Object, Object, Object)}.
 *
 * @param <A> the type of the first argument to the function
 * @param <B> the type of the second argument to the function
 * @param <C> the type of the third argument to the function
 * @param <D> the type of the fourth argument to the function
 * @param <RESULT> the type of the result of the function
 *
 * @see Function
 */
@FunctionalInterface
public interface QuadFunction<A, B, C, D, RESULT>
{
	/**
	 * Applies this function to the given arguments.
	 *
	 * @param a the first function argument
	 * @param b the second function argument
	 * @param c the third function argument
	 * @param d the fourth function argument
	 * @return the function result
	 */
	RESULT apply(A a, B b, C c, D d);

	/**
	 * Returns a composed function that first applies this function to
	 * its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param after the function to apply after this function is applied
	 * @param <RETURN> the type of output of the {@code after} function, and of the
	 * composed function
	 * @return a composed function that first applies this function and then
	 * applies the {@code after} function
	 * @throws NullPointerException if after is null
	 */
	default <RETURN> QuadFunction<A, B, C, D, RETURN> andThen(Function<? super RESULT, ? extends RETURN> after)
	{
		Objects.requireNonNull(after);
		return (a, b, c, d) -> after.apply(apply(a, b, c, d));
	}
}
