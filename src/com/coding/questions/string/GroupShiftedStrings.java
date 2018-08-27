package com.coding.questions.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(Object[] objects) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (Object s : objects) {
			String s1=(String)s;
			char[] arr = s1.toCharArray();
			if (arr.length > 0) {
				int diff = arr[0] - 'a';
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] - diff < 'a') {
						arr[i] = (char) (arr[i] - diff + 26);
					} else {
						arr[i] = (char) (arr[i] - diff);
					}

				}
			}

			String ns = new String(arr);
			if (map.containsKey(ns)) {
				map.get(ns).add(s1);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(s1);
				map.put(ns, al);
			}
		}

		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		result.addAll(map.values());

		return result;
	}
	
	public static void main(String[] args) {
		GroupShiftedStrings gs = new GroupShiftedStrings();
		ArrayList<String> testStrings= new ArrayList<String>();
		testStrings.add("abc");
		testStrings.add("bcd");
		testStrings.add("xyz");
		testStrings.add("az");
		testStrings.add("ba");
		testStrings.add("acef");
		testStrings.add("a");
		testStrings.add("z");
		System.out.println(gs.groupStrings(testStrings.toArray()));
	}
}
