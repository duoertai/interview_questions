package interview.twilio.phone.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            String hash = genCustomHash(s);
            if(!map.containsKey(hash))
                map.put(hash, new ArrayList<String>());
            map.get(hash).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> v: map.values())
            res.add(v);

        return res;
    }

    private String genCustomHash(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                sb.append((char) 'a' + i).append(count[i]);
            }
        }

        return sb.toString();
    }
}