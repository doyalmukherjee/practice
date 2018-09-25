package com.coding.questions.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDataDesign {
	private Map<Integer, Integer> elements = new HashMap<Integer, Integer>();

	public void add(int number) {
		if (elements.containsKey(number)) {
			elements.put(number, elements.get(number) + 1);
		} else {
			elements.put(number, 1);
		}
	}

	public boolean find(int value) {
		for (Integer i : elements.keySet()) {
			int target = value - i;
			if (elements.containsKey(target)) {
				if (i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		TwoSumDataDesign t1 = new TwoSumDataDesign();
		t1.add(11);
		t1.add(4);
		t1.add(1);
		t1.add(15);
		System.out.println(t1.find(4));
		System.out.println(t1.find(12));
		System.out.println(t1.find(26));
	}
}