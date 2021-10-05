/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.treap.naive;

import com.github.twofx.datastructures.random.IRandomNumberGenerator;

public class PersistentTreap<K extends Comparable<K>, V> {

	private final IRandomNumberGenerator random;
	private TreapNode<K, V> root;

	public PersistentTreap(IRandomNumberGenerator random) {
		this.random = random;
	}

	private PersistentTreap(PersistentTreap<K, V> other) {
		this.random = other.random;
		this.root = other.root;
	}

	@Override
	public PersistentTreap<K, V> clone() {
		return new PersistentTreap<>(this);
	}

	public V get(K key) {
		if (root == null) {
			return null;
		}
		var node = root.search(key);
		return node == null ? null : node.getValue();
	}

	public void put(K key, V value) {

	}

}
