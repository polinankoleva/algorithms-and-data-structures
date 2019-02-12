package com.java8;

public class LambdaMathOperationTester {

	public static void main(String[] args) {
		LambdaMathOperationTester tester = new LambdaMathOperationTester();

		MathOperation addition = (a, b) -> a + b;
		MathOperation division = (a, b) -> a / b;
		MathOperation multiplication = (a, b) -> a * b;
		
		GreetingService service = s -> System.out.println(s);
		service.greeting("Test");
		
		System.out.println(addition.operation(1, 2));
		System.out.println(tester.operation(6, 3, division));

	}

	private int operation(int a, int b, MathOperation op) {
		return op.operation(a, b);
	}
}

interface MathOperation {
	int operation(int a, int b);
}

interface GreetingService {
	void greeting(String s);
}
