package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.util.concurrent.Callable;

/**
 * An alternative to {@link Callable} where the input must always be nonnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Callable
 * @see Nonnull
 * @since 1.0.0-J8
 */
@FunctionalInterface
public interface NonnullCallable<@NonnullType T> extends Callable<T>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	T call() throws Exception;
}
