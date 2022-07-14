package xyz.apex.java.utility.api;

import org.jetbrains.annotations.ApiStatus;

import xyz.apex.java.utility.api.tuple.Couple;
import xyz.apex.java.utility.api.tuple.Pair;
import xyz.apex.java.utility.api.tuple.Quad;
import xyz.apex.java.utility.api.tuple.Triple;

import java.util.ServiceLoader;

@ApiStatus.NonExtendable
public abstract class JavaUtilities
{
	public static final JavaUtilities INSTANCE = ServiceLoader.load(JavaUtilities.class).findFirst().orElseThrow();

	public abstract <T> Couple<T> createMutableCouple(T key, T value);
	public abstract <T> Couple<T> createImmutableCouple(T key, T value);

	public abstract <K, V> Pair<K, V> createMutablePair(K key, V value);
	public abstract <K, V> Pair<K, V> createImmutablePair(K key, V value);

	public abstract <L, M, R> Triple<L, M, R> createMutableTriple(L left, M middle, R right);
	public abstract <L, M, R> Triple<L, M, R> createImmutableTriple(L left, M middle, R right);

	public abstract <A, B, C, D> Quad<A, B, C, D> createMutableQuad(A first, B second, C third, D fourth);
	public abstract <A, B, C, D> Quad<A, B, C, D> createImmutableQuad(A first, B second, C third, D fourth);
}