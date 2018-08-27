package com.coding.questions.array;

import java.util.Arrays;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
		 // Loop through all rows
        for (int[] row : matrix)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{5, 1, 9,11},//
						  {2, 4, 8,10},//
						  {13, 3, 6, 7},//
						  {15,14,12,16}};
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);
	}
}
