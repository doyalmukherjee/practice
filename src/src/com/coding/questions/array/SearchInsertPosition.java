package com.coding.questions.array;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (nums[end] < target) {
			return end + 1;
		} else if (nums[start] >= target) {
			return start;
		} else {
			return end;
		}
	}
	public static void main(String[] args) {
		SearchInsertPosition ins= new SearchInsertPosition();
		System.out.println(ins.searchInsert(new int[] {1,3,5,6}, 2));
	}
}
