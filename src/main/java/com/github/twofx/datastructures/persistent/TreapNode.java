/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent;

import com.github.twofx.datastructures.random.IRandomNumberGenerator;

class TreapNode<K extends Comparable<K>, V> {
	private final K key;
	private final V value;
	private final long priority;
	private TreapNode<K, V> left;
	private TreapNode<K, V> right;

	public TreapNode(K key, V value, IRandomNumberGenerator random) {
		this.key = key;
		this.value = value;
		this.priority = random.nextLong();
	}

	public TreapNode(TreapNode<K, V> toClone, V newValue) {
		this.key = toClone.key;
		this.value = newValue;
		this.priority = toClone.priority;
		this.left = toClone.left;
		this.right = toClone.right;
	}

	public TreapNode(TreapNode<K, V> toClone, TreapNode<K, V> newLeft, TreapNode<K, V> newRight) {
		this.key = toClone.key;
		this.value = toClone.value;
		this.priority = toClone.priority;
		this.left = newLeft;
		this.right = newRight;
	}

	public TreapNode<K, V> put(K searchKey, V valueToInsert, IRandomNumberGenerator random) {
		int comparison = key.compareTo(searchKey);
		if (comparison == 0) {
			return value == valueToInsert ? this : new TreapNode<>(this, valueToInsert);
		} else if (comparison > 0) {
			var newLeft = left == null ? new TreapNode<>(searchKey, valueToInsert, random)
					: left.put(searchKey, valueToInsert, random);
			return ensureHeapProperty(newLeft, right);
		} else {
			var newRight = right == null ? new TreapNode<>(searchKey, valueToInsert, random)
					: right.put(searchKey, valueToInsert, random);
			return ensureHeapProperty(left, newRight);
		}
	}

	/*
	 * We are allowed to assume that the heap property is violated on at most one
	 * side.
	 */
	private TreapNode<K, V> ensureHeapProperty(TreapNode<K, V> l, TreapNode<K, V> r) {
		if (getPriority(l) > Math.max(getPriority(r), priority)) {
			return new TreapNode<>(l, l.left, new TreapNode<>(this, l.right, r));
		} else if (getPriority(r) > Math.max(getPriority(l), priority)) {
			return new TreapNode<>(r, new TreapNode<>(this, l, r.left), r.right);
		} else {
			return new TreapNode<>(this, l, r);
		}
	}

	private static <K extends Comparable<K>, V> long getPriority(TreapNode<K, V> node) {
		return node == null ? Long.MIN_VALUE : node.priority;
	}

	public TreapNode<K, V> search(K searchKey) {
		int comparison = key.compareTo(searchKey);
		if (comparison == 0) {
			return this;
		} else if (comparison < 0) {
			return left == null ? null : left.search(searchKey);
		} else {
			return right == null ? null : right.search(searchKey);
		}
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	TreapNode<K, V> getLeft() {
		return left;
	}

	TreapNode<K, V> getRight() {
		return right;
	}
}
