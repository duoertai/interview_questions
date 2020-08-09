package interview.pinterest.phone.GraphValidTree;

import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 1)
            return true;

        if(edges == null || edges.length != n - 1)
            return false;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);

            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        if(!helper(map, visited, 0))
            return false;

        for(boolean f: visited)
            if(!f)
                return false;

        return true;
    }

    private boolean helper(Map<Integer, List<Integer>> map, boolean[] visited, int curr) {
        if(!map.containsKey(curr) || map.get(curr).size() == 0)
            return true;

        List<Integer> next = map.get(curr);
        for(Integer n: next) {
            map.get(n).remove((Integer) curr);
        }

        for(Integer n: next) {
            if(visited[n])
                return false;

            visited[n] = true;

            if(!helper(map, visited, n))
                return false;
        }

        return true;
    }
}