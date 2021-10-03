/*
 * Copyright (c) 2021 Markus Himmel
 * This file is distributed under the terms of the Apache License, Version 2.0 
 */
package com.github.twofx.datastructures.matchers;

import java.util.function.Function;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class MappingMatchers {
	private MappingMatchers() {
	}

	public static <T, U> Matcher<T> map(Function<T, U> projection, Matcher<U> matcher) {
		return new TypeSafeMatcher<T>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("After applying projection and matching ");
				matcher.describeTo(description);
			}

			@Override
			protected boolean matchesSafely(T item) {
				return matcher.matches(projection.apply(item));
			}

		};
	}
}
