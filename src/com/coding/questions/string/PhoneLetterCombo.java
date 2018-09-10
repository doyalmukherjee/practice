package com.coding.questions.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombo {
    public List<String> letterCombinations(final String digits) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        ArrayList<String> result = new ArrayList<String>();

        if(digits == null || digits.length() == 0)
            return result;

        ArrayList<Character> temp = new ArrayList<Character>();
        getString(digits, temp, result, map);

        return result;
    }

    public void getString(final String digits, final ArrayList<Character> temp, final ArrayList<String> result,  final HashMap<Integer, String> map){
        if(digits.length() == 0){
            char[] arr = new char[temp.size()];
            for(int i=0; i<temp.size(); i++){
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        }

        Integer curr = Integer.valueOf(digits.substring(0,1));
        String letters = map.get(curr);
        for(int i=0; i<letters.length(); i++){
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(final String[] args) {
        PhoneLetterCombo pc = new PhoneLetterCombo();
        System.out.println(pc.letterCombinations("23"));
    }
}
