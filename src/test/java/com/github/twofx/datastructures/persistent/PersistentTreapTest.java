package com.github.twofx.datastructures.persistent;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class PersistentTreapTest {

	@Test
	void test() {
		// arrange
		PersistentTreap t = new PersistentTreap();
		
		// act
		int k = t.five();
		
		// assert
		assertThat(k, is(5));
	}

}
