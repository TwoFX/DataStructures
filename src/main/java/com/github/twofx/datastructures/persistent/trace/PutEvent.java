/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

public class PutEvent<K, V> implements TraceEvent<K, V> {
	private static final long serialVersionUID = 1483936426020326986L;

	private final int id;
	private final K key;
	private final V value;

	public PutEvent(int id, K key, V value) {
		this.id = id;
		this.key = key;
		this.value = value;
	}

	@Override
	public void replay(MapVersionList<K, V> versionList) {
		versionList.get(id).put(key, value);
	}

}
