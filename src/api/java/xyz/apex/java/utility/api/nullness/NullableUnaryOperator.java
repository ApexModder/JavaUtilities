package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * An alternative to {@link UnaryOperator} where the input and result can be nullable
 *
 * @param <T> the type of the operand and result of the operator
 *
 * @see UnaryOperator
 * @see Nullable
 */
@FunctionalInterface
public interface NullableUnaryOperator<@NullableType T> extends UnaryOperator<T>, NullableFunction<T, T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see UnaryOperator#andThen(Function)
	 */
	default NullableUnaryOperator<T> andThen(NullableUnaryOperator<T> after)
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
	static <@NullableType T> NullableUnaryOperator<T> identity()
	{
		return t -> t;
	}
}