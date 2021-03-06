package interview.pinterest.phone.EmployeeFreeTime;

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
        if(schedule == null || schedule.size() == 0)
            return new ArrayList<>();

        List<Interval> list = new ArrayList<>();
        for(List<Interval> l: schedule) {
            list.addAll(l);
        }
        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        List<Interval> merged = new ArrayList<>();
        Interval temp = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).start > temp.end) {
                merged.add(temp);
                temp = list.get(i);
            } else {
                temp.end = Math.max(temp.end, list.get(i).end);
            }
        }

        merged.add(temp);
        List<Interval> res = new ArrayList<>();
        for(int i = 0; i < merged.size() - 1; i++) {
            res.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
        }

        return res;
    }

    public List<Interval> employeeFreeTimeHeap(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(schedule.size(), new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[2] - i2[2];
            }
        });

        int end = Integer.MAX_VALUE;
        for(int i = 0; i < schedule.size(); i++) {
            if(schedule.get(i) != null && schedule.get(i).size() != 0) {
                queue.offer(new int[] {i, 0, schedule.get(i).get(0).start, schedule.get(i).get(0).end});

                end = Math.min(end, schedule.get(i).get(0).end);
            }
        }

        while(queue.size() > 0) {
            int[] temp = queue.poll();
            if(end < temp[2]) {
                res.add(new Interval(end, temp[2]));
            }

            end = Math.max(end, temp[3]);

            if(temp[1] + 1 < schedule.get(temp[0]).size())
                queue.offer(new int[] {temp[0], temp[1] + 1, schedule.get(temp[0]).get(temp[1] + 1).start, schedule.get(temp[0]).get(temp[1] + 1).end});
        }

        return res;
    }
}
