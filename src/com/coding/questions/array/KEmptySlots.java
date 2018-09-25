package com.coding.questions.array;

import java.util.TreeSet;

public class KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> active = new TreeSet<Integer>();
		int day = 0;
		for (int flower : flowers) {
			day++;
			active.add(flower);
			Integer lower = active.lower(flower);
			Integer higher = active.higher(flower);
			if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k)
				return day;
		}
		return -1;
	}

	public int kEmptySlotsN(int[] flowers, int k) {
		// Build a days array to store which day a position flower bloom
		// Create an extra slot at the beginning and end make it easy to
		// process
		int[] days = new int[flowers.length + 2];
		days[0] = Integer.MAX_VALUE;
		days[days.length - 1] = Integer.MAX_VALUE;

		for (int i = 0; i < flowers.length; i++) {
			int day = i + 1;
			int pos = flowers[i];
			days[pos] = day;
		}

		// Two pointers of the window
		// Our goal is to find [l + 1, r - 1] that all bloom
		// but l and r do not not bloom.
		// a.k.a [l + 1, r - 1] must have smaller days than l and r.
		int l = 0;
		int r = k + 1;

		for (int i = 1; i < days.length; i++) {
			if (i == r || i == days.length - 1) {
				// Found a solution, go through the days in the window
				// and find the largest day
				int max = Integer.MIN_VALUE;

				for (int j = l + 1; j < i; j++) {
					max = Math.max(max, days[j]);
				}

				return max+1;
			} else {
				if (days[i] >= days[l] || days[i] >= days[r]) {
					// Found flower i in the window that bloom later than two ends
					// thus flower i cannot be in the window
					// Advance left pointer to i
					l = i;
					r = l + k + 1;

					if (r >= days.length) {
						// Cannot find a solution
						break;
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		KEmptySlots ks = new KEmptySlots();
		System.out.println(ks.kEmptySlotsN(new int[] { 1, 3, 2 }, 1));
	}
}
