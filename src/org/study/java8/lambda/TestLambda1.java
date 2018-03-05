package org.study.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class TestLambda1 {
	List<Employee> employeeList = Arrays.asList(new Employee(1, "����", 35, 5555.55f),
			new Employee(2, "����", 53, 8888.88f), new Employee(3, "����", 24, 6666.55f),
			new Employee(4, "����", 37, 9999.55f), new Employee(5, "����", 19, 7777.55f));

	// ��ȡ�������35��Ա��
	@Test
	public void test1() {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getAge() > 35) {
				emps.add(employee);
			}
		}

		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	// ��ȡ�������35��Ա��
	// @Test
	// public void test2() {
	// List<Employee> emps = filterEmployees(employeeList, new
	// MyPredicate<Employee>() {
	// public boolean test(Employee e) {
	// return e.getAge() > 35;
	// }
	// });
	//
	// for (Employee emp : emps) {
	// System.out.println(emp);
	// }
	// }
	//
	// public List<Employee> filterEmployees(List<Employee> list,
	// MyPredicate<Employee> predicate) {
	// List<Employee> emps = new ArrayList<>();
	// for (Employee employee : employeeList) {
	// if (predicate.test(employee)) {
	// emps.add(employee);
	// }
	// }
	//
	// return emps;
	// }

	public List<Employee> filterEmployees(List<Employee> list, Predicate<Employee> predicate) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (predicate.test(employee)) {
				emps.add(employee);
			}
		}

		return emps;
	}

	// ��ȡ���ʴ���7000��Ա��
	@Test
	public void test3() {
		List<Employee> emps = filterEmployees(employeeList, new Predicate<Employee>() {
			public boolean test(Employee e) {
				return e.getSalary() > 7000;
			}
		});

		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	// ��ȡ���ʴ���7000��Ա��
	@Test
	public void test4() {
		// List<Employee> emps = filterEmployees(employeeList, e -> e.getSalary() >
		// 7000);
		// List<Employee> emps = filterEmployees(employeeList, e -> {
		// return e.getSalary() > 7000;
		// });

		List<Employee> emps = filterEmployees(employeeList, (e) -> {
			return e.getSalary() > 7000;
		});

		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	// ��ȡ���ʴ���7000��Ա��
	@Test
	public void test5() {
		employeeList.stream().filter(new Predicate<Employee>() {
			public boolean test(Employee e) {
				return e.getSalary() > 7000;
			}
		}).forEach(emp -> System.out.println(emp));
	}

	// ��ȡ���ʴ���7000��Ա��,����������������
	@Test
	public void test6() {
		employeeList.stream().filter(emp -> emp.getSalary() > 7000).sorted().forEach(emp -> System.out.println(emp));
	}

	// ��ȡ���ʴ���7000��Ա��,�������ʽ�������
	@Test
	public void test7() {
		employeeList.stream().filter(emp -> emp.getSalary() > 7000).sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getSalary().compareTo(o1.getSalary());
			}
		}).forEach(emp -> System.out.println(emp));
	}

	// ��ȡ���ʴ���7000��Ա��,�������ʽ�������
	@Test
	public void test8() {
		employeeList.stream().filter(emp -> emp.getSalary() > 7000)
				.sorted((e1, e2) -> Float.compare(e2.getSalary(), e1.getSalary()))
				.forEach(emp -> System.out.println(emp));
	}
}
