package interview.google.FindEventualSafeStates;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null)
            return res;

        int n = graph.length;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            if(graph[i].length > 0) {
                if(!map.containsKey(i))
                    map.put(i, new HashSet<>());
                for(int next: graph[i])
                    map.get(i).add(next);
            }
        }

        Set<Integer> nums = new HashSet<>();

        for(int i = 0; i < n; i++) {
            helper(map, new HashSet<Integer>(), i, nums);
        }

        res = new ArrayList<>(nums);
        Collections.sort(res);

        return res;
    }

    private boolean helper(Map<Integer, Set<Integer>> map, Set<Integer> visited, int curr, Set<Integer> nums) {
        if(!map.containsKey(curr)) {
            nums.add(curr);
            return true;
        }

        if(nums.contains(curr))
            return true;

        visited.add(curr);

        Set<Integer> next = map.get(curr);
        for(Integer n: next) {
            if(visited.contains(n)) {
                visited.remove(curr);
                return false;
            }
            if(!helper(map, visited, n, nums)) {
                visited.remove(curr);
                return false;
            }
        }

        visited.remove(curr);
        nums.add(curr);

        return true;
    }
}
