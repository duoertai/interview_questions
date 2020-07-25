package interview.pinterest.MergeIntervals;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return intervals;

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        int[] temp = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > temp[1]) {
                res.add(temp);
                temp = intervals[i];
            } else {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
        }

        res.add(temp);
        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}