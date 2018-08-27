package com.coding.questions.dynamic;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
	    List<String> result = new ArrayList<String>();
	 
	    if(s==null)
	        return result;
	 
	    char[] arr = s.toCharArray();
	    for(int i=0; i<arr.length-1; i++){
	        if(arr[i]==arr[i+1] && arr[i]=='+'){
	            arr[i]='-';
	            arr[i+1]='-';
	            result.add(new String(arr));
	            arr[i]='+';
	            arr[i+1]='+';
	        }
	    }
	 
	    return result;
	}
	public static void main(String[] args) {
		FlipGame fg = new FlipGame();
		System.out.println(fg.generatePossibleNextMoves("+++-+"));
	}
}
