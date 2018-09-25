package com.coding.questions.dynamic;

public class HouseRobber {
	public int rob(int[] num) {
		int prevMax = 0;
		int currMax = 0;
		for (int x : num) {
			int temp = currMax;
			currMax = Math.max(prevMax + x, currMax);
			prevMax = temp;
		}
		return currMax;
	}
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[] {2,7,9,3,1}));
	}
}
