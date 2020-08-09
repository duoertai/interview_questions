package interview.pinterest.phone.LongestWordInDictionary;

import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return null;

        String res = "";
        int max = 0;

        Set<String> set = new HashSet<>();
        for(String word: words)
            set.add(word);

        for(int i = 0; i < words.length; i++) {
            boolean valid = true;
            for(int j = words[i].length() - 1; j >= 1; j--) {
                if(!set.contains(words[i].substring(0, j))) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                if(words[i].length() > max) {
                    max = words[i].length();
                    res = words[i];
                } else if(words[i].length() == max) {
                    if(words[i].compareTo(res) < 0) {
                        max = words[i].length();
                        res = words[i];
                    }
                }
            }
        }

        return res;
    }
}
