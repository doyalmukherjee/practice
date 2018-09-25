package com.coding.questions.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		s = s.replaceAll(" ", "");
		Stack<String> stack = new Stack<String>();
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				continue;
			if (arr[i] >= '0' || arr[i] <= '9') {
				sb.append(arr[i]);
				if (i == arr.length - 1)
					stack.push(sb.toString());
			} else {
				if (sb.length() > 0) {
					stack.push(sb.toString());
					sb = new StringBuilder();
				}

				if (arr[i] != ')') {
					stack.push(new String(new char[] { arr[i] }));
				} else {
					// when encountered ')'
					List<String> temp = new ArrayList<String>();
					while (!stack.isEmpty()) {
						String top = stack.pop();
						if (top.equals("(")) {
							break;
						} else {
							temp.add(0, top);
						}
					}
					int count = 0;
					if (temp.size() == 1) {
						count = Integer.valueOf(temp.get(0));
					} else {
						for (int j = temp.size() - 1; j > 0; j = j - 2) {
							if (temp.get(j - 1).equals("-")) {
								count += 0 - Integer.valueOf(temp.get(j));
							} else {
								count += Integer.valueOf(temp.get(j));
							}
						}
						count += Integer.valueOf(temp.get(0));
					}
					stack.push(String.valueOf(count));
				}
			}
		}

		List<String> temp = new ArrayList<String>();
		while (!stack.isEmpty()) {
			String top = stack.pop();
			temp.add(0, top);
		}

		int count = 0;
		for (int j = temp.size() - 1; j > 0; j = j - 2) {
			if (temp.get(j - 1).equals("-")) {
				count += 0 - Integer.valueOf(temp.get(j));
			} else {
				count += Integer.valueOf(temp.get(j));
			}
		}
		count += Integer.valueOf(temp.get(0));
		return count;
	}

	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("1 + 1"));
	}
}
