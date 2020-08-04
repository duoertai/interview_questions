package interview.apple.GroupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            String hash = getHash(s);
            if(!map.containsKey(hash))
                map.put(hash, new ArrayList<>());
            map.get(hash).add(s);
        }

        for(List<String> l: map.values())
            res.add(l);
        return res;
    }

    private String getHash(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++)
            if(count[i] > 0)
                sb.append('a' + i).append(count[i]);
        return sb.toString();
    }
}