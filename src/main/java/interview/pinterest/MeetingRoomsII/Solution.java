package interview.pinterest.MeetingRoomsII;

import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        int[][] times = new int[intervals.length * 2][2];
        for(int i = 0; i < intervals.length; i++) {
            times[2 * i][0] = intervals[i][0];
            times[2 * i][1] = 1;
            times[2 * i + 1][0] = intervals[i][1];
            times[2 * i + 1][1] = 0;
        }

        Arrays.sort(times, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if(i1[0] != i2[0]) {
                    return i1[0] - i2[0];
                }

                return i1[1] - i2[1];
            }
        });

        int res = 0;
        int count = 0;
        for(int i = 0; i < times.length; i++) {
            if(times[i][1] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count--;
            }
        }

        return res;
    }
}