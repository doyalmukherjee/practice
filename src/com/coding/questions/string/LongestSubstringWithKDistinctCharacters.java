package com.coding.questions.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) {
            return 0;
        }
        int[] ascii = new int[256];
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (count < k) {
                if (ascii[ch] == 0) {
                    count++;
                }
            } else if (ascii[ch] == 0){
                while (start < i) {
                    char ch1 = s.charAt(start++);
                    ascii[ch1]--;
                    if (ascii[ch1] == 0) {
                        break;
                    }
                }
            }
            ascii[ch]++;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinctUsingMap(String s, int k) {
    	if(k==0 || s==null || s.length()==0)
            return 0;
     
        if(s.length()<k)
            return s.length();
     
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
     
        int maxLen=k;
        int left=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
     
            if(map.size()>k){
                maxLen=Math.max(maxLen, i-left);
     
                while(map.size()>k){
                    char fc = s.charAt(left);
                    if(map.get(fc)==1){
                        map.remove(fc);
                    }else{
                        map.put(fc, map.get(fc)-1);
                    }
     
                    left++;
                }
            }
     
        }
     
        maxLen = Math.max(maxLen, s.length()-left);
     
        return maxLen;
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestSubstringWithKDistinctCharacters().lengthOfLongestSubstringKDistinctUsingMap("abcadcacacaca",3 ));
	}
}
