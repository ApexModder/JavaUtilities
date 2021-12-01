package xyz.apex.java.utility;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import xyz.apex.java.utility.nullness.NonnullUnaryOperator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Apex
{
	/**
	 * Creates a new {@link ImmutableList} while allowing you to add objects to it
	 *
	 * @param consumer Consumer used to add objects to the {@link ImmutableList}
	 * @param <V> Object type of values inside the list
	 * @return The newly built {@link ImmutableList}
	 * @since 1.0.0-J8
	 */
	public static <V> List<V> makeImmutableList(NonnullUnaryOperator<ImmutableList.Builder<V>> consumer)
	{
		return consumer.apply(ImmutableList.builder()).build();
	}

	/**
	 * Converts specified {@link List} into a {@link ImmutableList}
	 *
	 * @param list {@link List} to be made immutable
	 * @param <V> Object type of values inside the {@link List}
	 * @return The newly built {@link ImmutableList}
	 * @since 1.0.0-J8
	 */
	public static <V> List<V> makeImmutableList(List<V> list)
	{
		if(list instanceof ImmutableList)
			return list;
		return makeImmutableList(builder -> builder.addAll(list));
	}

	/**
	 * Creates a new {@link ImmutableSet} while allowing you to add objects to it
	 *
	 * @param consumer Consumer used to add objects to the {@link ImmutableSet}
	 * @param <V> Object type of values inside the set
	 * @return The newly built {@link ImmutableSet}
	 * @since 1.0.0-J8
	 */
	public static <V> Set<V> makeImmutableSet(NonnullUnaryOperator<ImmutableSet.Builder<V>> consumer)
	{
		return consumer.apply(ImmutableSet.builder()).build();
	}

	/**
	 * Converts specified {@link Set} into a {@link ImmutableSet}
	 *
	 * @param set {@link Set} to be made immutable
	 * @param <V> Object type of values inside the {@link Set}
	 * @return The newly built {@link ImmutableSet}
	 * @since 1.0.0-J8
	 */
	public static <V> Set<V> makeImmutableSet(Set<V> set)
	{
		if(set instanceof ImmutableSet)
			return set;
		return makeImmutableSet(builder -> builder.addAll(set));
	}

	/**
	 * Creates a new {@link ImmutableMap} while allowing you to add entries to it
	 *
	 * @param consumer Consumer used to add entries to the {@link ImmutableMap}
	 * @param <K> Object type of keys inside the map
	 * @param <V> Object type of values inside the map
	 * @return The newly built {@link ImmutableMap}
	 * @since 1.0.0-J8
	 */
	public static <K, V> Map<K, V> makeImmutableMap(NonnullUnaryOperator<ImmutableMap.Builder<K, V>> consumer)
	{
		return consumer.apply(ImmutableMap.builder()).build();
	}

	/**
	 * Converts specified {@link Map} into a {@link ImmutableMap}
	 *
	 * @param map {@link Map} to be made immutable
	 * @param <K> Object type of keys inside the {@link Map}
	 * @param <V> Object type of values inside the {@link Map}
	 * @return The newly built {@link ImmutableMap}
	 * @since 1.0.0-J8
	 */
	public static <K, V> Map<K, V> makeImmutableMap(Map<K, V> map)
	{
		if(map instanceof ImmutableMap)
			return map;
		return makeImmutableMap(builder -> builder.putAll(map));
	}
}
