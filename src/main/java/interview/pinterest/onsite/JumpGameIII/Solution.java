package interview.pinterest.onsite.JumpGameIII;

import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(start);
        while(queue.size() > 0) {
            int temp = queue.poll();
            visited.add(temp);

            if(arr[temp] == 0)
                return true;

            if(temp + arr[temp] < arr.length && !visited.contains(temp + arr[temp]))
                queue.offer(temp + arr[temp]);
            if(temp - arr[temp] >= 0 && !visited.contains(temp - arr[temp]))
                queue.offer(temp - arr[temp]);
        }

        return false;
    }
}
