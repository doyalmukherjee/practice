package com.coding.questions.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        int listIndex = 0;
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> anagramGroup = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (anagramGroup.containsKey(sorted)) {
                int index = anagramGroup.get(sorted);// if in map get the index from map. from that index(basically listIndex) get the resultlist or the group to be populated. 
                List<String> listResult = result.get(index);
                listResult.add(str);
            } else {
                List<String> resultList = new ArrayList<>();
                resultList.add(str);
                result.add(listIndex, resultList);
                anagramGroup.put(sorted, listIndex);
                listIndex++; // with this listindex you will store the index from which group  will be populated, also it is the map of the index. 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagramsTogether gt = new GroupAnagramsTogether();
        String[] words = { "cat", "dog", "tac", "god", "act" };
        System.out.println(gt.groupAnagrams(words));

    }
}
