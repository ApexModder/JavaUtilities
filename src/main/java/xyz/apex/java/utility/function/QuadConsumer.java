package xyz.apex.java.utility.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts four input arguments and returns no
 * result. This is the four-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code QuadConsumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a function interface whose function method is {@link #accept(Object, Object, Object, Object)}.
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the fourth argument to the operation
 *
 * @see Consumer
 */
@FunctionalInterface
public interface QuadConsumer<A, B, C, D>
{
	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param a The type of the first argument to the operation
	 * @param b The type of the second argument to the operation
	 * @param c The type of the third argument to the operation
	 * @param d The type of the third argument to the operation
	 */
	void accept(A a, B b, C c, D d);

	/**
	 * Returns a composed {@code QuadConsumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing this operation throws an exception,
	 * the {@code after} operation will not be performed.
	 *
	 * @param after The operation to perform after this operation
	 * @return a composed {@code QuadConsumer} that performs in sequence this
	 * operation followed by the {@code after} operation
	 * @throws NullPointerException if {@code after} is null
	 */
	default QuadConsumer<A, B, C, D> andThen(QuadConsumer<? super A, ? super B, ? super C, ? super D> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c, d) -> {
			accept(a, b, c, d);
			after.accept(a, b, c, d);
		};
	}

	/**
	 * Builds consumer that does nothing when applied
	 *
	 * @param <A> The type of first argument to the operation
	 * @param <B> The type of second argument to the operation
	 * @param <C> The type of third argument to the operation
	 * @param <D> The type of fourth argument to the operation
	 *
	 * @return Returns a consumer that does nothing when applied
	 */
	static <A, B, C, D> QuadConsumer<A, B, C, D> noop()
	{
		return (a, b, c, d) -> { };
	}
}
