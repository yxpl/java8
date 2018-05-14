package org.study.java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.study.java8.lambda.Employee;

public class MiddleStreamTest {
	//2. �м����
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
	public void filterTest() {
		//���е��м������������δ���
	 	Stream<Employee> stream = emps.stream().filter(emp -> {
	 		System.out.println("�����м����");
	 		return emp.getAge() < 35;
	 	});
	 	//ֻ������ֹ����ʱ�����е��м������һ���Ե�ȫ��ִ�У���Ϊ"������ֵ"
	 	stream.forEach(System.out::println);
	}
	
	//������������ζ�·
	@Test
	public void limitTest() {
		Stream<Employee> sm = emps.stream().filter(e -> {
			System.out.println("��·!");
			return Float.compare(e.getSalary(), 5000f) > 0;
		}).limit(2);
		sm.forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		Stream<Employee> stream = emps.stream().filter(e -> {
			System.out.println("��·!");
			return Float.compare(e.getSalary(), 6666.66f) > 0;
		}).limit(2);
		stream.forEach(System.out::println);
	}
	
	@Test
	public void skipTest() {
		Stream<Employee> stream = emps.stream().filter(e -> Float.compare(e.getSalary(), 5000) > 0).skip(2);
		stream.forEach(System.out::println);
	}
	
	@Test
	public void distinctTest() {
		Stream<Employee> stream = emps.stream().filter(e -> Float.compare(e.getSalary(), 5000) > 0).skip(2).distinct();
		stream.forEach(System.out::println);
	}
	
	@Test
	public void mapTest() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		Stream<String> stream = list.stream().map(str -> str.toUpperCase());
		stream.forEach(System.out::println);
	}
	
	@Test
	public void mapTest2() {
		Stream<String> map = emps.stream().map(e -> e.getName()).distinct();
		map.forEach(System.out::println);
	}
	
	@Test
	public void maxTest() {
		Optional<Employee> optional = emps.stream().max((e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return Float.compare(e1.getSalary(), e2.getSalary());
			}else {
				return Integer.compare(e2.getAge(), e1.getAge());
			}
		});
		
		System.out.println(optional.get());
	}
	
	@Test
	public void minTest() {
		Optional<Employee> optional = emps.stream().min((e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return Float.compare(e1.getSalary(), e2.getSalary());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		System.out.println(optional.get());
	}
	
	@Test
	public void sortedTest() {
		Optional<Employee> optional = emps.stream().sorted().findFirst();
		System.out.println(optional.get());
	}
	
	@Test
	public void sortedTest2() {
		Optional<Employee> optional = emps.stream().sorted((e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return Float.compare(e1.getSalary(), e2.getSalary());
			}else {
				return Integer.compare(e2.getAge(), e1.getAge());
			}
		}).findFirst();
		System.out.println(optional.get());
	}
}
