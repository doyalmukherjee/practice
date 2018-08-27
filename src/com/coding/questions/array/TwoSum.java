package com.coding.questions.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2]; // two indices
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) { //first check if current element exists in the list
				int index = map.get(numbers[i]);
				result[0] = index;
				result[1] = i;
				break;
			} else {
				map.put(target - numbers[i], i);  //put the target-current element, with index
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {11,4,1,15};
		int target =26;
		//given an array and the target, find two indices in arr whose sum is the target
		int[] result= new TwoSum().twoSum(arr, target);
		for (int i : result) {
			System.out.println(i+ ", ");
		}
	}
}
