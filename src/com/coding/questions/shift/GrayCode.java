package com.coding.questions.shift;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
	    if(n==0){
	        List<Integer> result = new ArrayList<Integer>();
	        result.add(0);
	        return result;
	    }
	    List<Integer> result = grayCode(n-1);
	    int numToAdd = 1<<(n-1);
	    System.out.println(Integer.toBinaryString(1 << (n-1)));
	 
	    for(int i=result.size()-1; i>=0; i--){
	        result.add(numToAdd+result.get(i));
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(2));
	}
}
