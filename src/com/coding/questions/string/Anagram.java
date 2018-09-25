package com.coding.questions.string;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
        System.out.println(isAnagram("DORMITORY", "Dirty Room"));
        System.out.println(isAnagram("ASTRONOMERS", "NO MORE STARS"));
    }

    private static boolean isAnagram(String s1, String s2) {
        //remove white spaces and convert cases
        String copyS1 = s1.replaceAll("\\s", "").toLowerCase();
        String copyS2 = s2.replaceAll("\\s", "").toLowerCase();
        if (copyS1.length() != copyS2.length()) {
            return false;
        }
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < copyS1.length(); i++) {
            //first char array (increment counter)
            char keyChar = copyS1.charAt(i);
            int charCounter = 0;
            if (charCountMap.containsKey(keyChar)) {
                charCounter = charCountMap.get(keyChar);
            }
            charCountMap.put(keyChar, ++charCounter);

            //second char array (decrement counter)
            keyChar = copyS2.charAt(i);
            charCounter = 0;
            if (charCountMap.containsKey(keyChar)) {
                charCounter = charCountMap.get(keyChar);
            }
            charCountMap.put(keyChar, --charCounter);
        }
        for (Integer countOfCharacter : charCountMap.values()) {
            if (countOfCharacter != 0) {
                return false;
            }
        }
        return true;
    }
}
