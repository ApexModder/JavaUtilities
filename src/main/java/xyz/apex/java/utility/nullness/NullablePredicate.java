package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * An alternative to {@link Predicate} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Predicate
 * @see Nullable
 */
@FunctionalInterface
public interface NullablePredicate<@NullableType T> extends Predicate<T>, NullableFunction<T, Boolean>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Predicate#test(Object)
	 */
	@Override
	boolean test(T t);

	/**
	 * {@inheritDoc}
	 *
	 * @see Function#apply(Object)
	 */
	@Override
	default Boolean apply(T t)
	{
		return test(t);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Predicate#and(Predicate)
	 */
	default NullablePredicate<T> and(NullablePredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) && other.test(t);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Predicate#or(Predicate)
	 */
	default NullablePredicate<T> or(NullablePredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) || other.test(t);
	}
}
