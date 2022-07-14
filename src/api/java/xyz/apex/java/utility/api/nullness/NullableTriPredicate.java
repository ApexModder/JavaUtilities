package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import xyz.apex.java.utility.api.function.TriPredicate;

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
 */
@FunctionalInterface
public interface NullableTriPredicate<@NullableType A, @NullableType B, @NullableType C> extends NullableTriFunction<A, B, C, Boolean>, TriPredicate<A, B, C>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#test(Object, Object, Object)
	 */
	@Override
	boolean test(A a, B b, C c);

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#apply(Object, Object, Object)
	 */
	@Override
	default Boolean apply(A a, B b, C c)
	{
		return test(a, b, c);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#and(TriPredicate)
	 */
	default NullableTriPredicate<A, B, C> and(NullableTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) && other.test(a, b, c);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TriPredicate#or(TriPredicate)
	 */
	default NullableTriPredicate<A, B, C> or(NullableTriPredicate<? super A, ? super B, ? super C> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c) -> test(a, b, c) || other.test(a, b, c);
	}
}