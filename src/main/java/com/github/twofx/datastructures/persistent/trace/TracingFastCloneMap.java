/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.github.twofx.datastructures.persistent.FastCloneMap;

public class TracingFastCloneMap<K, V> implements FastCloneMap<K, V> {
	private final MapTrace<K, V> trace;
	private final FastCloneMap<K, V> inner;
	private final int id;

	public TracingFastCloneMap(MapTrace<K, V> trace, FastCloneMap<K, V> inner) {
		this(trace, inner, false);
	}

	public TracingFastCloneMap(MapTrace<K, V> trace, FastCloneMap<K, V> inner, boolean registerEvent) {
		this.trace = trace;
		this.inner = inner;
		this.id = trace.getNewId();
		if (registerEvent && trace.isTracing()) {
			trace.registerEvent(new CreationEvent<>(id));
		}
	}

	@Override
	public int size() {
		return inner.size();
	}

	@Override
	public boolean isEmpty() {
		return inner.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return inner.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return inner.containsValue(value);
	}

	@Override
	public V get(Object key) {
		if (trace.isTracing()) {
			trace.registerEvent(new GetEvent<>(id, key));
		}
		return inner.get(key);
	}

	@Override
	public V put(K key, V value) {
		if (trace.isTracing()) {
			trace.registerEvent(new PutEvent<>(id, key, value));
		}
		return inner.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return inner.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		inner.putAll(m);
	}

	@Override
	public void clear() {
		inner.clear();

	}

	@Override
	public Set<K> keySet() {
		return inner.keySet();
	}

	@Override
	public Collection<V> values() {
		return inner.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return inner.entrySet();
	}

	@Override
	public FastCloneMap<K, V> shallowClone() {
		TracingFastCloneMap<K, V> clone = new TracingFastCloneMap<>(trace, inner.shallowClone());
		if (trace.isTracing()) {
			trace.registerEvent(new CloneEvent<>(id, clone.id));
		}
		return clone;
	}
}
