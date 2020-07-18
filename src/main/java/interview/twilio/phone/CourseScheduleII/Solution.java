package interview.twilio.phone.CourseScheduleII;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            inDegree[prerequisite[0]]++;

            if (!graph.containsKey(prerequisite[1]))
                graph.put(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            List<Integer> next = graph.get(curr);
            if (next == null)
                continue;

            for(int n: next) {
                inDegree[n]--;
                if (inDegree[n] == 0)
                    queue.offer(n);
            }
        }

        if (order.size() == numCourses) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                res[i] = order.get(i);
            return res;
        } else {
            return new int[0];
        }
    }
}
