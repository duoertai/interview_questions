package interview.pinterest.onsite.MinimumWindowSubstring;

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(!target.containsKey(t.charAt(i)))
                target.put(t.charAt(i), 1);
            else
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
        }

        int p1 = 0;
        int p2 = 0;
        Map<Character, Integer> source = new HashMap<>();
        String res = "";

        while(p2 < s.length()) {
            while(p2 < s.length() && !includeAll(source, target)) {
                char c = s.charAt(p2);
                if(!source.containsKey(c))
                    source.put(c, 1);
                else
                    source.put(c, source.get(c) + 1);

                p2++;
            }

            if(!includeAll(source, target))
                return res;

            while(p1 < p2 && includeAll(source, target)) {
                char c = s.charAt(p1);
                if(source.get(c) == 1)
                    source.remove(c);
                else
                    source.put(c, source.get(c) - 1);

                p1++;
            }

            String temp = s.substring(p1 - 1, p2);
            if(res.length() == 0 || temp.length() < res.length()) {
                res = temp;
            }
        }

        return res;
    }

    private boolean includeAll(Map<Character, Integer> source, Map<Character, Integer> target) {
        for(Character key: target.keySet()) {
            if(!source.containsKey(key) || source.get(key) < target.get(key))
                return false;
        }

        return true;
    }
}
