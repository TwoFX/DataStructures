/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

public class CreationEvent<K, V> implements TraceEvent<K, V> {
	private static final long serialVersionUID = -6933246288729298319L;

	private final int id;

	public CreationEvent(int id) {
		this.id = id;
	}

	@Override
	public void replay(MapVersionList<K, V> versionList) {
		versionList.create(id);
	}

}
