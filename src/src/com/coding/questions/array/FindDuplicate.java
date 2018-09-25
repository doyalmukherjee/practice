package com.coding.questions.array;

public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int find = 0;
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
	public static void main(String[] args) {
		FindDuplicate fd = new FindDuplicate();
		System.out.println(fd.findDuplicate(new int[] {3,1,3,4,2}));
	}
}
