package com.coding.questions.dynamic;

public class ContainerWithMaxWater {
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
	 
		int max = 0;
		int left = 0;
		int right = height.length - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
	 
		return max;
	}
	
	 public static void main(String[] args) {
		
		 int a[] = {1, 5, 4, 3};
		 int b[] = {3, 1, 2, 4, 5};
		 System.out.print(maxArea(a)+"\n" );
		 System.out.print(maxArea(b) );
	}
}
