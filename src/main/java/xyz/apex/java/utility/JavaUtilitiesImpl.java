package xyz.apex.java.utility;

import xyz.apex.java.utility.api.JavaUtilities;
import xyz.apex.java.utility.api.tuple.Couple;
import xyz.apex.java.utility.api.tuple.Pair;
import xyz.apex.java.utility.api.tuple.Quad;
import xyz.apex.java.utility.api.tuple.Triple;
import xyz.apex.java.utility.immutable.ImmutableCouple;
import xyz.apex.java.utility.immutable.ImmutablePair;
import xyz.apex.java.utility.immutable.ImmutableQuad;
import xyz.apex.java.utility.immutable.ImmutableTriple;
import xyz.apex.java.utility.mutable.MutableCouple;
import xyz.apex.java.utility.mutable.MutablePair;
import xyz.apex.java.utility.mutable.MutableQuad;
import xyz.apex.java.utility.mutable.MutableTriple;

public final class JavaUtilitiesImpl extends JavaUtilities
{
	@Override
	public <T> Couple<T> createMutableCouple(T key, T value)
	{
		return new MutableCouple<>(key, value);
	}

	@Override
	public <T> Couple<T> createImmutableCouple(T key, T value)
	{
		return new ImmutableCouple<>(key, value);
	}

	@Override
	public <K, V> Pair<K, V> createMutablePair(K key, V value)
	{
		return new MutablePair<>(key, value);
	}

	@Override
	public <K, V> Pair<K, V> createImmutablePair(K key, V value)
	{
		return new ImmutablePair<>(key, value);
	}

	@Override
	public <L, M, R> Triple<L, M, R> createMutableTriple(L left, M middle, R right)
	{
		return new MutableTriple<>(left, middle, right);
	}

	@Override
	public <L, M, R> Triple<L, M, R> createImmutableTriple(L left, M middle, R right)
	{
		return new ImmutableTriple<>(left, middle, right);
	}

	@Override
	public <A, B, C, D> Quad<A, B, C, D> createMutableQuad(A first, B second, C third, D fourth)
	{
		return new MutableQuad<>(first, second, third, fourth);
	}

	@Override
	public <A, B, C, D> Quad<A, B, C, D> createImmutableQuad(A first, B second, C third, D fourth)
	{
		return new ImmutableQuad<>(first, second, third, fourth);
	}
}