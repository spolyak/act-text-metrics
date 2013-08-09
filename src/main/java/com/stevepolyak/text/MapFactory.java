package com.stevepolyak.text;

import java.util.*;

/**
 * Factory for creating maps.
 */

public class MapFactory {
	/**
	 * Create a new unsorted map (HashMap).
	 */

	public static <K, V> Map<K, V> createNewMap() {
		return new HashMap<K, V>();
	}

	/**
	 * Create a new unsorted map (HashMap) with specified initial capacity.
	 * 
	 * @param capacity
	 *            Initial capacity.
	 */

	public static <K, V> Map<K, V> createNewMap(int capacity) {
		return new HashMap<K, V>(capacity);
	}

	/**
	 * Create a new map with keys in insertion order (LinkedHashMap).
	 */

	public static <K, V> Map<K, V> createNewLinkedMap() {
		return new LinkedHashMap<K, V>();
	}

	/**
	 * Create a new map with keys in insertion order (LinkedHashMap) with
	 * specified initial capacity..
	 * 
	 * @param capacity
	 *            Initial capacity.
	 */

	public static <K, V> Map<K, V> createNewLinkedMap(int capacity) {
		return new LinkedHashMap<K, V>(capacity);
	}

	/**
	 * Create a new sorted map (TreeMap).
	 */

	public static <K, V> Map<K, V> createNewSortedMap() {
		return new TreeMap<K, V>();
	}

	/** Don't allow instantiation, do allow overrides. */

	protected MapFactory() {
	}
}
