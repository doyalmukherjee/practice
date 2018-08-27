package com.coding.questions.string;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class WordDistanceFinder {
	final List<String> words;

	public WordDistanceFinder(List<String> words) {
		this.words = words;
	}

	public int distance(String wordOne, String wordTwo) {
		if (wordTwo == null || wordOne == null) {
			throw new NullPointerException("Words cannot be null");
		}

		Integer lastWordOneIndex = null;
		Integer lastWordTwoIndex = null;
		Integer minValue = Integer.MAX_VALUE;
		Integer turn=0;
		if(wordOne.equals(wordTwo))
			turn=1;
		for (int i = 0; i < words.size(); i++) {
			final String currentWord = words.get(i);
			if (wordOne.equals(currentWord) &&(turn==0||turn==1)) {
				lastWordOneIndex = i;
				if(turn==1) turn=2;
				if (lastWordTwoIndex != null) {
					minValue = Math.min(minValue, lastWordOneIndex - lastWordTwoIndex);
				}
			} else if (wordTwo.equals(currentWord)&&(turn==0||turn==2)) {
				lastWordTwoIndex = i;
				if(turn==2) turn=1;
				if (lastWordOneIndex != null) {
					minValue = Math.min(minValue, lastWordTwoIndex - lastWordOneIndex);
				}
			}
		}

		if (lastWordTwoIndex == null || lastWordOneIndex == null) {
			throw new InvalidParameterException("Words are not on the list");
		}

		if(wordOne.equals(wordTwo))
			return turn;
		
		return minValue;
	}
	public static void main(String[] args) {
		WordDistanceFinder wf = new WordDistanceFinder(Arrays.asList("the","brown", "quick", "fox","test", "quick"));
		System.out.println(wf.distance("brown", "the"));
		//System.out.println(wf.distance("quick", "quick"));
	}
}
