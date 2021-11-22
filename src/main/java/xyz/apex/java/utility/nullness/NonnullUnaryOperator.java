package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface NonnullUnaryOperator<@NonnullType T> extends UnaryOperator<T>, NonnullFunction<T, T>
{
	default NonnullUnaryOperator<T> andThen(NonnullUnaryOperator<T> after)
	{
		Objects.requireNonNull(after);
		return t -> after.apply(apply(t));
	}

	static <@NonnullType T> NonnullUnaryOperator<T> identity()
	{
		return t -> t;
	}
}
