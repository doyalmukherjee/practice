package com.coding.questions.array;

import java.util.HashSet;

public class ContainsDuplicateAtMostK {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	    if(nums==null || nums.length<2 || k==0)
	        return false;
	 
	    int i=0; 
	 
	    HashSet<Integer> set = new HashSet<Integer>();
	 
	    for(int j=0; j<nums.length; j++){
	        if(!set.add(nums[j])){
	            return true;
	        }            
	 
	        if(set.size()>=k+1){
	            set.remove(nums[i++]);
	        }
	    }
	 
	    return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateAtMostK ck = new ContainsDuplicateAtMostK();
		System.out.println(ck.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}
}
