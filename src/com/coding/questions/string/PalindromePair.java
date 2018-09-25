package com.coding.questions.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePair {
	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null || words.length < 2) {
			return Collections.EMPTY_LIST;
		}
		Map<String, Integer> wordMap = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			wordMap.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String str1 = words[i].substring(0, j + 1);
				String str2 = words[i].substring(j + 1, words[i].length());
				if (isPalindrome(str2)) {
					String revStr1 = new StringBuilder(str1).reverse().toString();
					Integer index = wordMap.get(revStr1);
					if (index != null) {
						createList(i, wordMap.get(revStr1), result);
					}
				}
				if (isPalindrome(str1)) {
					String revStr2 = new StringBuilder(str2).reverse().toString();
					Integer index = wordMap.get(revStr2);
					if (index != null) {
						createList(wordMap.get(revStr2), i, result);
						if (revStr2.equals("")) {
							createList(i, wordMap.get(revStr2), result);
						}
					}
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String word) {
		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private void createList(int i1, int i2, List<List<Integer>> result) {
		if (i1 == i2) {
			return;
		}
		List<Integer> r = new ArrayList<>();
		r.add(i1);
		r.add(i2);
		result.add(r);
	}

	public static void main(String args[]) {
		PalindromePair palindromePair = new PalindromePair();
		/*String[] words = { "bat", "tab" };
		List<List<Integer>> result = palindromePair.palindromePairs(words);
		System.out.println(result);*/
		String[] words1 = { "lls", "s", "sssll" };
		List<List<Integer>> result = palindromePair.palindromePairs(words1);
		System.out.println(result);
		/*String[] words2 = { "", "abcd", "abba" };
		result = palindromePair.palindromePairs(words2);
		System.out.println(result);
		String[] words3 = { "a", "abc", "aba", "" };
		result = palindromePair.palindromePairs(words3);
		System.out.println(result);
		String[] words4 = { "abcd", "dcba", "lls", "s", "sssll" };
		result = palindromePair.palindromePairs(words4);
		System.out.println(result);*/
	}
}
