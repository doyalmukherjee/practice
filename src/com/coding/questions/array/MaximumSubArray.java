package com.coding.questions.array;

public class MaximumSubArray {
	public int maxSubArray(int[] A) {
		int newsum = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			newsum = Math.max(newsum + A[i], A[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumSubArray ms = new MaximumSubArray();
		System.out.println(ms.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
