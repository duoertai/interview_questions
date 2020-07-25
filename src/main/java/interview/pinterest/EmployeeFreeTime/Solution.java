package interview.pinterest.EmployeeFreeTime;

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
}
