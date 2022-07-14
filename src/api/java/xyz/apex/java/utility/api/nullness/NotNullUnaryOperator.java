package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * An alternative to {@link UnaryOperator} where the input and result must always be notnull
 *
 * @param <T> the type of the operand and result of the operator
 *
 * @see UnaryOperator
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullUnaryOperator<@NotNullType T> extends UnaryOperator<T>, NotNullFunction<T, T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see UnaryOperator#andThen(Function)
	 */
	default NotNullUnaryOperator<T> andThen(NotNullUnaryOperator<T> after)
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
	static <@NotNullType T> NotNullUnaryOperator<T> identity()
	{
		return t -> t;
	}
}