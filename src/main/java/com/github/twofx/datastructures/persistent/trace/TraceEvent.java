/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent.trace;

import java.io.Serializable;

public interface TraceEvent<K, V> extends Serializable {
	public void replay(MapVersionList<K, V> versionList);
}
