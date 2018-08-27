package com.coding.questions.array;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	int x = Integer.MAX_VALUE;
    	int y = Integer.MAX_VALUE;
     
    	for (int i = 0; i < nums.length; i++) {
    		int z = nums[i];
     
    		if (x >= z) {
    			x = z;// update x to be a smaller value
    		} else if (y >= z) {
    			y = z; // update y to be a smaller value
    		} else {
    			return true;
    		}
    	}
     
    	return false;
    }

    public static void main(String args[]) {
        IncreasingTripletSubsequence tripletSubsequence = new IncreasingTripletSubsequence();
        int input[] = {9, 10, -2, 4, -1,-4}; //{12, 11, 10, 5, 6, 2, 30}; 
        System.out.print(tripletSubsequence.increasingTriplet(input));
    }
}
