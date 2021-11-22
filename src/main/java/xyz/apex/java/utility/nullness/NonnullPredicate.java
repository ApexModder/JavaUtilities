package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface NonnullPredicate<@NonnullType T> extends Predicate<T>, NonnullFunction<T, Boolean>
{
	@Override
	boolean test(T t);

	@Override
	default Boolean apply(T t)
	{
		return test(t);
	}

	default NonnullPredicate<T> and(NonnullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) && other.test(t);
	}

	default NonnullPredicate<T> or(NonnullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) || other.test(t);
	}
}
