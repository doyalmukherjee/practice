package com.coding.questions.array;

public class FirstPositiveMissing {
	public int firstMissingPositive(int[] A) {
		int n = A.length;

		for (int i = 0; i < n; i++) {
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] >= n)
					break;

				if (A[i] == A[A[i] - 1])
					break;

				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;
	}

	private int segregate(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (nums[start] <= 0) {
				start++;
			} else if (nums[end] > 0) {
				end--;
			} else {
				swap(nums, start, end);
			}
		}
		return start;
	}

	private void swap(int[] nums, int start, int end) {
		int t = nums[start];
		nums[start] = nums[end];
		nums[end] = t;
	}

	public static void main(String[] args) {
		FirstPositiveMissing fp = new FirstPositiveMissing();
		System.out.println(fp.firstMissingPositive(new int[] { 3,4,-1,1 }));
	}
}
