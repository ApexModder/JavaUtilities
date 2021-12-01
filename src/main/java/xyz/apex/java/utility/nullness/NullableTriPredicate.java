package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.TriPredicate;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * An alternative to {@link TriPredicate} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 *
 * @see TriPredicate
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableTriPredicate<@NullableType A, @NullableType B, @NullableType C> extends NullableTriFunction<A, B, C, Boolean>, TriPredicate<A, B, C>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean test(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 */
	@Override
	default Boolean apply(A a, B b, C c)
	{
		return test(a, b, c);
	}

	/**
	 * @see TriPredicate#and(TriPredicate)
	 */
	default NullableTriPredicate<A, B, C> and(NullableTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}

	/**
	 * @see TriPredicate#or(TriPredicate)
	 */
	default NullableTriPredicate<A, B, C> or(NullableTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}
