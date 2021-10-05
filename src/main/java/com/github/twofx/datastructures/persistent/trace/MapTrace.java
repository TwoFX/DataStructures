/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.twofx.datastructures.persistent.FastCloneMap;

public class MapTrace<K, V> implements IMapTrace<K, V>, Serializable {
	private static final long serialVersionUID = 78156995582725932L;

	private transient int nextIndex = 0;
	private final List<TraceEvent<K, V>> events = new ArrayList<>();

	public void registerEvent(TraceEvent<K, V> event) {
		events.add(event);
	}

	@Override
	public int getNewId() {
		return nextIndex++;
	}

	@Override
	public boolean isTracing() {
		return true;
	}

	@Override
	public FastCloneMap<K, V> register(FastCloneMap<K, V> map) {

		return new TracingFastCloneMap<>(this, map);
	}

}
