package com.coding.questions.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetingCharacter {

    public int lengthOfLongestSubstring(String s) {
    	 if(s==null||s.length()==0){
    	        return 0;
    	    }
    	    int result = 0;
    	    int k=0;
    	    HashSet<Character> set = new HashSet<Character>();
    	    for(int i=0; i<s.length(); i++){
    	        char c = s.charAt(i);
    	        if(!set.contains(c)){
    	            set.add(c);
    	            result = Math.max(result, set.size());
    	        }else{
    	            while(k<i){
    	                if(s.charAt(k)==c){
    	                    k++;
    	                    break;
    	                }else{
    	                    set.remove(s.charAt(k));
    	                    k++;
    	                }
    	            }
    	        }  
    	    }
    	    return result;
    }
    
    public static void main(String args[]){
        LongestSubstringWithoutRepetingCharacter lsw = new LongestSubstringWithoutRepetingCharacter();
        System.out.println(lsw.lengthOfLongestSubstring("bpfbhmipx"));
    }
}
