package org.study.java8.functionalinterface;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateTest {
	@Test
	public void testTest() {
		Predicate<Integer> predicate = i -> i > 3;
		System.out.println(predicate.test(2));
		System.out.println(predicate.test(3));
		System.out.println(predicate.test(4));
	}
	
	@Test
	public void andTest() {
		Predicate<Integer> predicate = i -> i > 3;
		predicate = predicate.and(i -> i < 5);
		System.out.println(predicate.test(3));
		System.out.println(predicate.test(4));
		System.out.println(predicate.test(5));
	}
}
