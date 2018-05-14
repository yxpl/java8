package org.study.java8.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {
	@Test
	public void applyTest() {
		Integer incr = 20;
		Integer myNumber = 10;
		modifyTheValue(myNumber, val -> val + incr);
		myNumber = 15;
		modifyTheValue(myNumber, val -> val * 10);
		modifyTheValue(myNumber, val -> val - 100);
		modifyTheValue(myNumber, val -> "somestring".length() + val - 100);
	}

	public void modifyTheValue(Integer valueToBeOperated, Function<Integer, Integer> function) {
		int newValue = function.apply(valueToBeOperated);
		System.out.println(newValue);
	}

	@Test
	public void instanceMethodTest() {
		Function<Integer, Integer> times2 = i -> i * 2;
		Function<Integer, Integer> squared = i -> i * i;
		System.out.println(times2.apply(4));
		System.out.println(squared.apply(4));
		System.out.println(times2.compose(squared).apply(4));
		System.out.println(times2.andThen(squared).apply(4));
		System.out.println(Function.identity().compose(squared).apply(4));		
	}

	/**
	 * 使用List<? extends T>声明，不能添加元素，因为不能确定元素的具体类型
	 * 可以读取出T或者T的子类
	 * 使用List<? super T>声明，可以添加T或者T的父类元素，读取时不能确定类型，是Object或Object子类对象
	 * 生产者使用extends，可以从中读取到T类型的元素
	 * 消费者使用super，可以向其中添加T类型的元素
	 * 参考java.util.Collections里的copy方法
	 * public static <T> void copy(List<? super T> dest, List<? extends T> src) 
	 */
	@Test
	public void genericityExtendsTest1() {
		List<? extends Object> list = new ArrayList<>();
//		list.add(Integer.valueOf("1234", 2));
//		list.add(new String("qwe"));
	}
	
	@Test
	public void genericitySuperTest() {
		List<? super Number> list = new ArrayList<>();
		list.add(1);
		list.add(Integer.valueOf("3"));
		list.add(Integer.valueOf("12343"));
		list.add(2f);
		list.add(6.7f);
		list.add(Double.valueOf("3.46"));
		judgeGenericType2(list);
	}

	@Test
	public void genericityExtendsTest() {
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(4);
		integerList.add(7);
		judgeGenericType(integerList);

		System.out.println("-------------------------");

		List<Double> doubleList = new ArrayList<>();
		doubleList.add(1.1);
		doubleList.add(4.3);
		doubleList.add(Double.valueOf("7.8D"));
		judgeGenericType(doubleList);

		System.out.println("-------------------------");

		List objectList = new ArrayList<>();
		objectList.add(11.1);
		objectList.add(9);
		objectList.add(14.3f);
		objectList.add(Double.valueOf("17.8D"));
		judgeGenericType(objectList);
	}

	public void judgeGenericType(List<? extends Number> list) {
		for (int i = 0; i < list.size(); i++) {
			Number number = list.get(i);
			if (number instanceof Integer) {
				System.out.println(number + " --> Integer");
			} else if (number instanceof Double) {
				System.out.println(number + " --> Double");
			} else if (number instanceof Float) {
				System.out.println(number + " --> Float");
			}
		}
	}
	
	public void judgeGenericType2(List<? super Number> list) {
		for (int i = 0; i < list.size(); i++) {
			Number number = (Number) list.get(i);
			if (number instanceof Integer) {
				System.out.println(number + " --> Integer");
			} else if (number instanceof Double) {
				System.out.println(number + " --> Double");
			} else if (number instanceof Float) {
				System.out.println(number + " --> Float");
			}
		}
	}
}
