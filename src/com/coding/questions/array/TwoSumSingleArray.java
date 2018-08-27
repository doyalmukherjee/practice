package com.coding.questions.array;

public class TwoSumSingleArray {
	
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
	 
		int i = 0;
		int j = numbers.length - 1;
	 
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				++i;
			} else if (x > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
	 
		return null;
	}

	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target =9;
		//given an array and the target, find two indices in arr whose sum is the target
		int[] result= new TwoSumSingleArray().twoSum(arr, target);
		for (int i : result) {
			System.out.println(i+ ", ");
		}
	}
}
