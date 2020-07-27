package interview.pinterest.WordBreakII;

import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);

        return helper(map, set, s.length(), s);
    }

    private List<String> helper(HashMap<Integer, List<String>> map, Set<String> set, int end, String s) {
        if(end == 0) {
            map.put(0, new ArrayList<>());
            map.get(0).add("");
            return map.get(0);
        }

        if(map.containsKey(end)) {
            return map.get(end);
        }

        List<String> res = new ArrayList<>();

        for(int i = 0; i <= end; i++) {
            String str = s.substring(i, end);

            if(set.contains(str)) {
                helper(map, set, i, s);
                List<String> prev = helper(map, set, i, s);
                for(String p: prev) {
                    res.add(p + (p.length() == 0 ? "" : " ") + str);
                }
            }
        }

        map.put(end, res);
        return res;
    }
}
