package com.coding.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
		Arrays.sort(S);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			// get sets that are already in result
			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}

			// add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}

			// add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);

			result.addAll(temp);
		}
		// add empty set
		result.add(new ArrayList<Integer>());
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[] {1,2,3}));
	}
}
