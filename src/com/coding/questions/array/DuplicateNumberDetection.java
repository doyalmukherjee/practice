package com.coding.questions.array;

public class DuplicateNumberDetection {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String args[]) {
        int[] input = {2,1,2,4,3};
        DuplicateNumberDetection dd = new DuplicateNumberDetection();
        System.out.println(dd.findDuplicate(input));
    }
}
