/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent;

import java.util.Map;

public interface FastCloneMap<K, V> extends Map<K, V> {
	public FastCloneMap<K, V> shallowClone();
}
