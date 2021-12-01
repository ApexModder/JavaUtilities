package xyz.apex.java.utility.nullness;

import xyz.apex.java.utility.function.QuadPredicate;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * An alternative to {@link QuadPredicate} where the inputs can be nullable
 *
 * @param <A> The type of the first argument to the operation
 * @param <B> The type of the second argument to the operation
 * @param <C> The type of the third argument to the operation
 * @param <D> The type of the third argument to the operation
 *
 * @see QuadPredicate
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableQuadPredicate<@NullableType A, @NullableType B, @NullableType C, @NullableType D> extends NullableQuadFunction<A, B, C, D, Boolean>, QuadPredicate<A, B, C, D>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#test(Object, Object, Object, Object)
	 */
	@Override
	boolean test(A a, B b, C c, D d);

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#apply(Object, Object, Object, Object)
	 */
	@Override
	default Boolean apply(A a, B b, C c, D d)
	{
		return test(a, b, c, d);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#and(QuadPredicate)
	 */
	default NullableQuadPredicate<A, B, C, D> and(NullableQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) && other.test(a, b, c, d);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see QuadPredicate#or(QuadPredicate)
	 */
	default NullableQuadPredicate<A, B, C, D> or(NullableQuadPredicate<? super A, ? super B, ? super C, ? super D> other)
	{
		Objects.requireNonNull(other);
		return (a, b, c, d) -> test(a, b, c, d) || other.test(a, b, c, d);
	}
}
