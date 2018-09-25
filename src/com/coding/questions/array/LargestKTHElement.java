package com.coding.questions.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestKTHElement {
	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

	public int findKthLargestHeap(int[] nums, int k) {
		Comparator<Integer> inComp = new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return 0;
			}
		};
		
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(inComp);
	    
	    
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}
	
	public static void main(String[] args) {
		LargestKTHElement lk = new LargestKTHElement();
		System.out.println(lk.findKthLargestHeap(new int[] {3,2,1,5,6,4}, 2));
	}
}
