package interview.pinterest.onsite.EmployeeFreeTime;

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

import interview.Interval;

import java.util.*;

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();

        int end = Integer.MAX_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue(schedule.size(), new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[2] - i2[2];
            }
        });

        for(int i = 0; i < schedule.size(); i++) {
            end = Math.min(end, schedule.get(i).get(0).end);
            queue.offer(new int[] {
                    i,
                    0,
                    schedule.get(i).get(0).start,
                    schedule.get(i).get(0).end
            });
        }

        while(queue.size() > 0) {
            int[] temp = queue.poll();

            if(end < temp[2]) {
                res.add(new Interval(end, temp[2]));
            }
            end = Math.max(end, temp[3]);

            if(temp[1] + 1 < schedule.get(temp[0]).size())
                queue.offer(new int[]{
                        temp[0],
                        temp[1] + 1,
                        schedule.get(temp[0]).get(temp[1] + 1).start,
                        schedule.get(temp[0]).get(temp[1] + 1).end
                });
        }

        return res;
    }
}