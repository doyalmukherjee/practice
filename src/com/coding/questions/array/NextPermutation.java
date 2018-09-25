package com.coding.questions.array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		// scan element to find first element less than previous one
		int p = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				p = i;
				break;
			}
		}

		// scan from right to left, find the first element that is greater than p.
		int q = 0;
		for (int i = nums.length - 1; i > p; i--) {
			if (nums[i] > nums[p]) {
				q = i;
				break;
			}
		}

		//edge case of sorting
		if (p == 0 && q == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		
		// swap p and q
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
		
		// reverse elements [p+1, nums.length]
		if (p < nums.length - 1) {
			reverse(nums, p + 1, nums.length - 1);
		}

		System.out.println(Arrays.toString(nums));
	}

	public void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		np.nextPermutation(new int[] { 4, 5, 6, 3, 2 ,1 });
	}
}
