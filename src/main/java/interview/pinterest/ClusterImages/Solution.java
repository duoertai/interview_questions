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

    public static List<List<String>> clusterImageBfs(Map<String, List<String>> map) {
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, HashSet<String>> graph = new HashMap<>();

        for(String image: map.keySet()) {
            graph.put(image, new HashSet<>(map.get(image)));
        }

        for(String image: graph.keySet()) {
            Set<String> next = graph.get(image);
            for(String n: next) {
                graph.get(n).add(image);
            }
        }

        for(String image: graph.keySet()) {
            if(!visited.contains(image))
                bfs(graph, visited, res, new ArrayList<>(), image);
        }

        return res;
    }

    private static void bfs(Map<String, HashSet<String>> map, Set<String> visited, List<List<String>> res, List<String> cluster, String curr) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(curr);

        while(!queue.isEmpty()) {
            String temp = queue.poll();
            visited.add(temp);
            cluster.add(temp);

            if(map.containsKey(temp)) {
                Set<String> next = map.get(temp);
                for(String n: next) {
                    if(!visited.contains(n)) {
                        map.get(n).remove(temp);
                        queue.offer(n);
                    }
                }
            }
        }

        res.add(cluster);
    }

    public static List<List<String>> clusterImageDfs(Map<String, List<String>> map) {
        return null;
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

        List<List<String>> res = clusterImageBfs(map);
        for(List<String> r: res) {
            for(String s: r)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
