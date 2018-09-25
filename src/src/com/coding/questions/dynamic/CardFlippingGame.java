package com.coding.questions.dynamic;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> same = new HashSet<Integer>();
		for (int i = 0; i < fronts.length; ++i)
			if (fronts[i] == backs[i])
				same.add(fronts[i]);

		int ans = 9999;
		for (int x : fronts)
			if (!same.contains(x))
				ans = Math.min(ans, x);

		for (int x : backs)
			if (!same.contains(x))
				ans = Math.min(ans, x);

		return ans % 9999;
	}
	
	public static void main(String[] args) {
		CardFlippingGame cf = new CardFlippingGame();
		System.out.println(cf.flipgame(new int[] {1,2,4,4,7}, new int[] {1,3,4,1,3}));
	}
}
