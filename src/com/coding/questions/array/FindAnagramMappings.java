package com.coding.questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {
	public int[] anagramMappings(int[] A, int[] B) {
		Map<Integer, Integer> D = new HashMap<Integer, Integer>();
		for (int i = 0; i < B.length; i++)
			D.put(B[i], i);

		int[] ans = new int[A.length];
		int t = 0;
		for (int x : A)
			ans[t++] = D.get(x);
		return ans;
	}
	
	public static void main(String[] args) {
		FindAnagramMappings fa = new FindAnagramMappings();
		System.out.println(Arrays.toString(fa.anagramMappings(new int[] {12, 28, 46, 32, 50}, new int[] {50, 12, 32, 46, 28})));
	}
}
