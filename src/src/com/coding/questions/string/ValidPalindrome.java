package com.coding.questions.string;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isAlphaNum(s.charAt(start))) {
                start++;
            } else if (!isAlphaNum(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphaNum(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
		ValidPalindrome vp= new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
	}

}
