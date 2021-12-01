package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * An alternative to {@link Predicate} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Predicate
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullablePredicate<@NullableType T> extends Predicate<T>, NullableFunction<T, Boolean>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean test(T t);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(T t)
	{
		return test(t);
	}

	/**
	 * @see Predicate#and(Predicate)
	 */
	default NullablePredicate<T> and(NullablePredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) && other.test(t);
	}

	/**
	 * @see Predicate#or(Predicate)
	 */
	default NullablePredicate<T> or(NullablePredicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return t -> test(t) || other.test(t);
	}
}
