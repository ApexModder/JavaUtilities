package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
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
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableUnaryOperator<@NullableType T> extends UnaryOperator<T>, NullableFunction<T, T>
{
	/**
	 * @see UnaryOperator#andThen(Function)
	 */
	default NullableUnaryOperator<T> andThen(NullableUnaryOperator<T> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	/**
	 * @see UnaryOperator#identity()
	 */
	static <@NullableType T> NullableUnaryOperator<T> identity()
	{
		return t -> t;
	}
}
