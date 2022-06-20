package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.Nullable;

import java.util.concurrent.Callable;

/**
 * An alternative to {@link Callable} where the input can be nullable
 *
 * @param <T> The type of the input to the operation
 *
 * @see Callable
 * @see Nullable
 */
@FunctionalInterface
public interface NullableCallable<@NullableType T> extends Callable<T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Callable#call()
	 */
	@Override
	T call() throws Exception;
}
