package interview.pinterest.phone.SmallestRangeCoveringElementsFromKLists;

import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[] {-100000, 100000};
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            public int compare(String i1, String i2) {
                String[] s1 = i1.split(",");
                String[] s2 = i2.split(",");

                int n1 = Integer.parseInt(s1[2]);
                int n2 = Integer.parseInt(s2[2]);

                if(n1 != n2)
                    return n1 - n2;

                return i1.compareTo(i2);
            }
        });

        for(int i = 0; i < nums.size(); i++) {
            String s = "" + i + "," + 0 + "," + nums.get(i).get(0);
            set.add(s);
        }

        while(set.size() == nums.size()) {
            String[] min = set.first().split(",");
            String[] max = set.last().split(",");

            int n1 = Integer.parseInt(min[2]);
            int n2 = Integer.parseInt(max[2]);

            if(n2 - n1 < res[1] - res[0]) {
                res[0] = n1;
                res[1] = n2;
            }

            set.remove(set.first());
            if(Integer.parseInt(min[1]) + 1 < nums.get(Integer.parseInt(min[0])).size())
                set.add(min[0] + "," + (Integer.parseInt(min[1]) + 1) + "," + nums.get(Integer.parseInt(min[0])).get(Integer.parseInt(min[1]) + 1));
        }

        return res;
    }
}