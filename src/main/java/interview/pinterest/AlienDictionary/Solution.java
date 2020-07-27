package interview.pinterest.AlienDictionary;

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0)
            return "";

        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(String w: words) {
            for(int i = 0; i < w.length(); i++) {
                set.add(w.charAt(i));
            }
        }

        Map<Character, Integer> in = new HashMap<>();
        for(Character c: set) {
            in.put(c, 0);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            int j = 0;
            for(; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1 != c2) {
                    if(!map.containsKey(c1))
                        map.put(c1, new HashSet<>());
                    map.get(c1).add(c2);
                    break;
                }
            }
            if(j == len && s1.length() > s2.length())
                return "";

        }

        for(Character key: map.keySet()) {
            Set<Character> next = map.get(key);
            for(Character c: next) {
                in.put(c, in.get(c) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<Character> queue = new LinkedList<>();
        for(Character key: in.keySet()) {
            if(in.get(key) == 0)
                queue.offer(key);
        }

        while(queue.size() > 0) {
            char c = queue.poll();
            sb.append(c);
            if(!map.containsKey(c)) {
                continue;
            } else {
                Set<Character> next = map.get(c);
                for(Character n: next) {
                    in.put(n, in.get(n) - 1);
                    if(in.get(n) == 0)
                        queue.offer(n);
                }
            }
        }
        if(sb.length() != set.size())
            return "";
        return sb.toString();
    }
}