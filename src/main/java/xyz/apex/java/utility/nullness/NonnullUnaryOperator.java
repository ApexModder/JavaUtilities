package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * An alternative to {@link UnaryOperator} where the input and result must always be nonnull
 *
 * @param <T> the type of the operand and result of the operator
 *
 * @see UnaryOperator
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullUnaryOperator<@NonnullType T> extends UnaryOperator<T>, NonnullFunction<T, T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see UnaryOperator#andThen(Function)
	 */
	default NonnullUnaryOperator<T> andThen(NonnullUnaryOperator<T> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @param <T> the type of the input and output objects to the function
	 * @return a function that always returns its input argument
	 *
	 * @see UnaryOperator#identity()
	 */
	static <@NonnullType T> NonnullUnaryOperator<T> identity()
	{
		return t -> t;
	}
}
