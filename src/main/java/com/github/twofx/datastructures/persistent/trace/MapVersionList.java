/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.github.twofx.datastructures.persistent.FastCloneMap;

public class MapVersionList<K, V> {
	private final List<FastCloneMap<K, V>> versions = new ArrayList<>();
	private final Supplier<FastCloneMap<K, V>> newMap;

	public MapVersionList(Supplier<FastCloneMap<K, V>> newMap) {
		this.newMap = newMap;
	}

	public FastCloneMap<K, V> get(int index) {
		return versions.get(index);
	}

	public void put(int index, FastCloneMap<K, V> map) {
		assertCorrectInsertionIndex(index);
		versions.add(map);
	}

	public void create(int index) {
		assertCorrectInsertionIndex(index);
		versions.add(newMap.get());
	}

	private void assertCorrectInsertionIndex(int index) {
		if (index != versions.size()) {
			throw new IllegalStateException("Incorrect sequence of operations.");
		}
	}
}
