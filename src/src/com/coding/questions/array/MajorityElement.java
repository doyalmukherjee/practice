package com.coding.questions.array;

public class MajorityElement {
	public int majorityElement(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	 
	    return result;
	}
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(new int[] {1,2,3,4,5,6}));
	}
}
