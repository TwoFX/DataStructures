/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.treap.naive;

import static com.github.twofx.datastructures.matchers.MappingMatchers.map;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.nullValue;

import org.hamcrest.Matcher;

public class TreapNodeMatchers {
	private TreapNodeMatchers() {
	}

	public static <K extends Comparable<K>, V> Matcher<TreapNode<K, V>> node(Matcher<? super K> keyMatcher,
			Matcher<? super V> valueMatcher, Matcher<? super TreapNode<K, V>> leftMatcher,
			Matcher<? super TreapNode<K, V>> rightMatcher) {
		return allOf(map(TreapNode<K, V>::getKey, keyMatcher), map(TreapNode<K, V>::getValue, valueMatcher),
				map(TreapNode<K, V>::getLeft, leftMatcher), map(TreapNode<K, V>::getRight, rightMatcher));
	}

	public static <K extends Comparable<K>, V> Matcher<TreapNode<K, V>> node(Matcher<? super K> keyMatcher,
			Matcher<? super V> valueMatcher) {
		return allOf(map(TreapNode<K, V>::getKey, keyMatcher), map(TreapNode<K, V>::getValue, valueMatcher),
				map(TreapNode<K, V>::getLeft, nullValue()), map(TreapNode<K, V>::getRight, nullValue()));
	}
}
