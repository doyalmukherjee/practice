package com.coding.questions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
	
	public static void main(String[] args) {
		GroupAnagrams ga= new GroupAnagrams();
		System.out.println(ga.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}