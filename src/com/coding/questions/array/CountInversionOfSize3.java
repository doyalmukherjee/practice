package com.coding.questions.array;

public class CountInversionOfSize3 {

    /**
     * Time complexity of this method is O(n^2)
     * Space complexity is O(1)
     */
    public int findInversions(int input[]) {
        int inversion = 0;
        for (int i = 1; i < input.length - 1 ; i++) {
            int larger = 0;
            // count all greater elements on left of arr[i]
            for (int k = 0; k < i; k++) {
                if (input[k] > input[i]) {
                    larger++;
                }
            }
            
            // count all smaller elements on right of arr[i]
            int smaller = 0;
            for (int k = i+1; k < input.length; k++) {
                if (input[k] < input[i]) {
                    smaller++;
                }
            }
            
            // update inversion count by adding all inversions
            // that have arr[i] as middle of three elements
            inversion += smaller*larger;
        }
        return inversion;
    }

    public static void main(String args[]) {
        int input[] = {8, 4, 2, 1};
        CountInversionOfSize3 ci = new CountInversionOfSize3();
        System.out.print(ci.findInversions(input));
    }
}