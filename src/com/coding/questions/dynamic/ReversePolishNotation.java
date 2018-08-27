package com.coding.questions.dynamic;

import java.io.IOException;
import java.util.Stack;

public class ReversePolishNotation {
	public static void main(String[] args) throws IOException {
		String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {

		int returnValue = 0;

		String operators = "+-*/";

		Stack<String> stack = new Stack<String>(); 

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;

	}
}
