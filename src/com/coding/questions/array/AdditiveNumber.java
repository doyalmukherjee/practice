package com.coding.questions.array;

import java.math.BigInteger;

public class AdditiveNumber {

	public boolean isAdditiveNumber(String num) {
		
		//finding the start of numbers 
		if (num.length() < 3) {
			return false;
		}
		for (int i = 0; i <= num.length() / 2; i++) {// start with every i element, checking only till half as that will suffice
			if (num.charAt(0) == '0' && i > 0) {
				break;
			}
			BigInteger x1 = new BigInteger(num.substring(0, i + 1)); 
			// make sure remaining size is at least size of first and second integer.
			for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1; j++) { //increment j for evevery element till lenghth-the length of the string
				if (num.charAt(i + 1) == '0' && j > i + 1) {
					break;
				}
				BigInteger x2 = new BigInteger(num.substring(i + 1, j + 1));
				if (isValid(num, j + 1, x1, x2)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
		if (start == num.length()) {
			return true;
		}
		BigInteger x3 = x1.add(x2);
		// if num starts with x3 from offset start means x3 is found. So look for next
		// number.
		return num.startsWith(x3.toString(), start) && isValid(num, start + x3.toString().length(), x2, x3);
		//Recursively progress across the string by the second index of start
	}
	
	public static void main(String[] args) {
		AdditiveNumber a= new AdditiveNumber();
		System.out.println(a.isAdditiveNumber("199100199"));
	}

}
