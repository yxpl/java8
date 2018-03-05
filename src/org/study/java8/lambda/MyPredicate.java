package org.study.java8.lambda;

@FunctionalInterface
public interface MyPredicate<T> {
	boolean test(T t);
}
