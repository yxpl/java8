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
		// 1��Collectionϵ�м��ϵ�stream()������parallelStream()����
		List<String> list = new ArrayList<String>(Arrays.asList("aa", "bb", "cc"));
		Stream<String> listStream = list.stream();
		listStream.forEach(System.out::println);

		// 2��Arrays��stream()��̬����
		Employee[] employees = new Employee[3];
		Stream<Employee> employeesStream = Arrays.stream(employees);
		System.out.println(employeesStream);

		// 3��Stream��of()��̬����
		Stream<String> ofStream = Stream.of("11", "22", "33");
		ofStream.forEach(System.out::println);

		// 4��������
		// ����
		Stream<Integer> iterateStream = Stream.iterate(0, x -> x + 2);
		iterateStream.limit(10).forEach(System.out::println);

		// ����
		Stream<Double> generateStream = Stream.generate(() -> Math.random());
		generateStream.limit(10).forEach(System.out::println);
	}
}
