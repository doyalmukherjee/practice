package com.coding.questions.array;

public class RemoveDuplicateAllowTwo {
	public static int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
 
		int prev = 1; // point to previous
		int curr = 2; // point to current //2 at that is the most duplicates allowed
 
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) { //to catch duplicates as it goes beyond atmost 3 places
				curr++; //if duplicate do not do anything
			} else {//chnange elements within array
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
 
		return prev + 1;
	}
	
	 public static void main (String[] args) 
	    {
	        int arr[] = {1, 2, 2, 2, 4, 4, 4, 5, 5};
	        int n = arr.length;
	         
	        n = removeDuplicates(arr);
	  
	        // Print updated array
	        for (int i=0; i<n; i++)
	           System.out.print(arr[i]+" ");
	    }

}
