/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

public class GetEvent<K, V> implements TraceEvent<K, V> {
	private static final long serialVersionUID = -3114416493862114147L;

	private final int id;
	private final Object key;

	public GetEvent(int id, Object key) {
		this.id = id;
		this.key = key;
	}

	@Override
	public void replay(MapVersionList<K, V> versionList) {
		versionList.get(id).get(key);
	}

}
