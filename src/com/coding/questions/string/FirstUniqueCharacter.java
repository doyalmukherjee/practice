package com.coding.questions.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacter {
	public int firstUniqChar(String s) {
		Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
		}
		char temp = ' ';
		for (Entry<Character, Integer> entry : charMap.entrySet()) {
			if (entry.getValue() == 1) {
				temp = entry.getKey();
				break;
			}
		}
		int returnIndex = temp == ' '?-1:s.indexOf(temp);
		return returnIndex;
	}

	public static void main(String[] args) {
		System.out.println(new FirstUniqueCharacter().firstUniqChar("loveleetcode"));
	}
}
