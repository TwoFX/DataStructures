/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import com.github.twofx.datastructures.persistent.FastCloneMap;

public class NoOpMapTrace<K, V> implements IMapTrace<K, V> {

	@Override
	public int getNewId() {
		return 0;
	}

	@Override
	public void registerEvent(TraceEvent<K, V> event) {
		// No-op
	}

	@Override
	public boolean isTracing() {
		return false;
	}

	@Override
	public FastCloneMap<K, V> register(FastCloneMap<K, V> map) {
		return map;
	}

}
