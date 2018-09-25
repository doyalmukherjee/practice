package com.coding.questions.array;

public class RotateArray {
	public static void rotate(int[] arr, int order) {	
		if (arr == null || arr.length==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		if(order > arr.length){
			order = order %arr.length;
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		
		//print
		for (int i : arr) {
			System.out.print(i+" ");
		}
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
	
	public static void main(String[] args) {
		RotateArray ra= new RotateArray();
		ra.rotate(new int[] {1,2,3,4,5,6,7}, 8);
	}

}
