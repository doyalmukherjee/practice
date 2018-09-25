package com.coding.questions.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(final String s, final Set<String> wordDict) {
        int[] pos = new int[s.length() + 1];

        Arrays.fill(pos, -1);

        pos[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        pos[j] = i;
                    }
                }
            }
        }
        return pos[s.length()] != -1;
    }

    public static void main(final String[] args) {
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("apple");
        wordDict.add("pen");

        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("applepenapple", wordDict));
    }
}
