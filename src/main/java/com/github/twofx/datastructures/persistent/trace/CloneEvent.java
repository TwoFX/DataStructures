/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

public class CloneEvent<K, V> implements TraceEvent<K, V> {
	private static final long serialVersionUID = -2034251121059930549L;

	private final int oldId;
	private final int newId;

	public CloneEvent(int oldId, int newId) {
		this.oldId = oldId;
		this.newId = newId;
	}

	@Override
	public void replay(MapVersionList<K, V> versionList) {
		versionList.put(newId, versionList.get(oldId).shallowClone());
	}

}
