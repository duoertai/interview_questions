package interview.pinterest.ClusterImages;

import java.util.*;

public class Solution {
    public static List<List<String>> clusterImage(Map<String, List<String>> map) {
        int n = map.size();
        int index = 0;
        Map<String, Integer> indexes = new HashMap<>();
        Map<Integer, List<String>> cluster = new HashMap<>();
        for(String key: map.keySet()) {
            indexes.put(key, index++);
        }

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = -1;
        }

        for(String image: map.keySet()) {
            if(map.get(image).size() == 0)
                continue;

            List<String> similar = map.get(image);
            for(String s: similar) {
                int i1 = indexes.get(image);
                int i2 = indexes.get(s);

                int e1 = find(nums, i1);
                int e2 = find(nums, i2);
                if(e1 != e2) {
                    nums[e1] = e2;
                }
            }
        }

        for(String image: map.keySet()) {
            int i = indexes.get(image);
            int end = find(nums, i);
            if(!cluster.containsKey(end))
                cluster.put(end, new ArrayList<>());
            cluster.get(end).add(image);
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll(cluster.values());

        return res;
    }

    private static int find(int[] nums, int i) {
        while(nums[i] != -1) {
            i = nums[i];
        }

        return i;
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("B", "F"));
        map.put("B", Arrays.asList("C"));
        map.put("C", Arrays.asList());
        map.put("D", Arrays.asList());
        map.put("E", Arrays.asList("D"));
        map.put("F", Arrays.asList());
        map.put("G", Arrays.asList("F"));

        List<List<String>> res = clusterImage(map);
        for(List<String> r: res) {
            for(String s: r)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
