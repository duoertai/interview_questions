package interview.twilio.oa.CanYouSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void customSort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums) {
            if (!count.containsKey(n))
                count.put(n, 1);
            else
                count.put(n, count.get(n) + 1);
        }

        // construct a int[][] for sorting by frequency and value
        int[][] res = new int[count.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }

        // custom sorting
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        // reconstruct the int array with original form
        index = 0;
        for(int[] r: res) {
            for(int i = 0; i < r[1]; i++) {
                nums[index++] = r[0];
            }
        }

        // printing
        for(int n: nums)
            System.out.println(n);
    }

    public static void main(String[] args){
        Solution.customSort(new int[] {4,5,6,5,4,3});
    }
}
