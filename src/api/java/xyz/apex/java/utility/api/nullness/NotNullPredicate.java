package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * An alternative to {@link Predicate} where the input must always be notnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Predicate
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullPredicate<@NotNullType T> extends Predicate<T>, NotNullFunction<T, Boolean>
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
	default NotNullPredicate<T> and(NotNullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) && other.test(t);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Predicate#or(Predicate)
	 */
	default NotNullPredicate<T> or(NotNullPredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) || other.test(t);
	}
}