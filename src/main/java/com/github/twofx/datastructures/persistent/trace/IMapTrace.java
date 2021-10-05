/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import com.github.twofx.datastructures.persistent.FastCloneMap;

public interface IMapTrace<K, V> {
	public int getNewId();

	public void registerEvent(TraceEvent<K, V> event);

	public boolean isTracing();

	public FastCloneMap<K, V> register(FastCloneMap<K, V> map);
}
