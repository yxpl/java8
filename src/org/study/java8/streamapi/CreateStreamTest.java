package org.study.java8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.study.java8.lambda.Employee;

/**
 * @author xin
 * @since 2018/05/01
 */
public class CreateStreamTest {
	@Test
	public void test1() {
		// 1、Collection系列集合的stream()方法和parallelStream()方法
		List<String> list = new ArrayList<String>(Arrays.asList("aa", "bb", "cc"));
		Stream<String> listStream = list.stream();
		listStream.forEach(System.out::println);

		// 2、Arrays的stream()静态方法
		Employee[] employees = new Employee[3];
		Stream<Employee> employeesStream = Arrays.stream(employees);
		System.out.println(employeesStream);

		// 3、Stream的of()静态方法
		Stream<String> ofStream = Stream.of("11", "22", "33");
		ofStream.forEach(System.out::println);

		// 4、无限流
		// 迭代
		Stream<Integer> iterateStream = Stream.iterate(0, x -> x + 2);
		iterateStream.limit(10).forEach(System.out::println);

		// 生成
		Stream<Double> generateStream = Stream.generate(() -> Math.random());
		generateStream.limit(10).forEach(System.out::println);
	}
}
