package com.coding.questions.array;

import java.util.Arrays;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int l = 0, r = nums.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] > m) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		System.out.println(mn.missingNumber(new int [] {9,6,4,2,3,5,7,0,1}));
	}
}
