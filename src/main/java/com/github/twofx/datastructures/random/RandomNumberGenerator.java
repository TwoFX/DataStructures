/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.random;

import java.util.Random;

public class RandomNumberGenerator implements IRandomNumberGenerator {
	private Random random;

	public RandomNumberGenerator(long seed) {
		random = new Random(seed);
	}

	@Override
	public long nextLong() {
		return random.nextLong();
	}
}
