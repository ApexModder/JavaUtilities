package xyz.apex.java.utility.function;

import java.util.Objects;
import java.util.function.Predicate;

public final class Predicates
{
	/**
	 * Returns a predicate that always evaluates to {@code true}
	 *
	 * @param <T> the object type of the predicate
	 * @return a predicate that always evaluates to {@code true}
	 */
	public static <T> Predicate<T> alwaysTrue()
	{
		return t -> true;
	}

	/**
	 * Returns a predicate that always evaluates to {@code false}
	 *
	 * @param <T> the object type of the predicate
	 * @return a predicate that always evaluates to {@code false}
	 */
	public static <T> Predicate<T> alwaysFalse()
	{
		return t -> false;
	}

	/**
	 * Returns a predicate that evaluates to {@code true} if the object reference being tested is
	 * null.
	 *
	 * @param <T> the object type of the predicate
	 * @return a predicate that evaluates to {@code true} if the object reference being tested is
	 * null.
	 */
	public static <T> Predicate<T> isNull()
	{
		return Objects::isNull;
	}
}
