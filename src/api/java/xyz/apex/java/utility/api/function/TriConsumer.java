package xyz.apex.java.utility.api.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts three input arguments and returns no
 * result. This is the three-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code TriConsumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a function interface whose function method is {@link #accept(Object, Object, Object)}.
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see Consumer
 */
@FunctionalInterface
public interface TriConsumer<A, B, C>
{
	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param a The type of the first argument to the operation
	 * @param b The type of the second argument to the operation
	 * @param c The type of the third argument to the operation
	 */
	void accept(A a, B b, C c);

	/**
	 * Returns a composed {@code TriConsumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing this operation throws an exception,
	 * the {@code after} operation will not be performed.
	 *
	 * @param after The operation to perform after this operation
	 * @return a composed {@code TriConsumer} that performs in sequence this
	 * operation followed by the {@code after} operation
	 * @throws NullPointerException if {@code after} is null
	 */
	default TriConsumer<A, B, C> andThen(TriConsumer<? super A, ? super B, ? super C> after)
	{
		Objects.requireNonNull(after);

		return (a, b, c) -> {
			accept(a, b, c);
			after.accept(a, b, c);
		};
	}

	/**
	 * Builds consumer that does nothing when applied
	 *
	 * @param <A> The type of first argument to the operation
	 * @param <B> The type of second argument to the operation
	 * @param <C> The type of third argument to the operation
	 *
	 * @return Returns a consumer that does nothing when applied
	 */
	static <A, B, C> TriConsumer<A, B, C> noop()
	{
		return (a, b, c) -> { };
	}
}