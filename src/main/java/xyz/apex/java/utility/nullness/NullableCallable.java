package xyz.apex.java.utility.nullness;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

/**
 * An alternative to {@link Callable} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Callable
 * @see Nullable
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NullableCallable<@NullableType T> extends Callable<T>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	T call() throws Exception;
}
