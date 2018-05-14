package org.study.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.study.java8.lambda.Employee;

public class TerminateStreamTest {
	//2. ��ֹ����
	List<Employee> emps = Arrays.asList(
			new Employee(102, "����", 59, 6666.66f),
			new Employee(101, "����", 18, 9999.99f),
			new Employee(103, "����", 28, 3333.33f),
			new Employee(104, "����", 8, 7777.77f),
			new Employee(104, "����", 8, 7777.77f),
			new Employee(104, "����", 8, 7777.77f),
			new Employee(107, "����", 38, 5555.55f)
	);
	
	@Test
	public void reduceTest() {
		Optional<Float> optional = emps.stream().map(Employee::getSalary).reduce((x,y) -> x + y);
		System.out.println(optional.get());
	}
}
