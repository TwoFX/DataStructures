/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.persistent;

import static com.github.twofx.datastructures.persistent.TreapNodeMatchers.node;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

import com.github.twofx.datastructures.random.FixedSequenceRandomNumberGenerator;
import com.github.twofx.datastructures.random.IRandomNumberGenerator;

class TreapNodeTest {

	@Test
	void put_SHOULD_produceTreeWithTwoNodes() {
		// arrange
		IRandomNumberGenerator random = new FixedSequenceRandomNumberGenerator(2, 1);
		TreapNode<String, String> root = new TreapNode<>("a", "A", random);

		// act
		TreapNode<String, String> newRoot = root.put("b", "B", random);

		// assert
		assertThat(newRoot, node(is("a"), is("A"), is(nullValue()), node(is("b"), is("B"))));
	}

	@Test
	void put_SHOULD_performARotation() {
		// arrange
		IRandomNumberGenerator random = new FixedSequenceRandomNumberGenerator(1, 2);
		TreapNode<String, String> root = new TreapNode<>("a", "A", random);

		// act
		TreapNode<String, String> newRoot = root.put("b", "B", random);

		// assert
		assertThat(newRoot, node(is("b"), is("B"), node(is("a"), is("A")), is(nullValue())));
	}

}
