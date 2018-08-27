package com.coding.questions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		//paragraph += ".";

		Set<String> banset = new HashSet<String>(Arrays.asList(banned));
		/*for (String word : banned)
			banset.add(word);*/
		Map<String, Integer> count = new HashMap<String,Integer>();
		String ans = "";
		int ansfreq = 0;
		String[] words = paragraph.split("\\W+");
		for (String word : words) {
			String finalword = word.toString().toLowerCase();
			if (!banset.contains(finalword)) {
				count.put(finalword, count.getOrDefault(finalword, 0) + 1);
				if (count.get(finalword) > ansfreq) {
					ans = finalword;
					ansfreq = count.get(finalword);
				}
			}
		}
		/*StringBuilder word = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}*/
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit", new String[] {"hit"}));
	}
}
