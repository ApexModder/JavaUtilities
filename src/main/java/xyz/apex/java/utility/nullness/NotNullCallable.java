package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;

/**
 * An alternative to {@link Callable} where the input must always be notnull
 *
 * @param <T> The type of the input to the operation
 *
 * @see Callable
 * @see NotNull
 */
@FunctionalInterface
public interface NotNullCallable<@NotNullType T> extends Callable<T>
{
	/**
	 * {@inheritDoc}
	 *
	 * @see Callable#call()
	 */
	@Override
	T call() throws Exception;
}
