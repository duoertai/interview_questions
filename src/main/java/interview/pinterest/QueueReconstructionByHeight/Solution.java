package interview.pinterest.QueueReconstructionByHeight;

import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if(i1[0] != i2[0])
                    return i2[0] - i1[0];
                return i1[1] - i2[1];
            }
        });

        for(int[] p: people) {
            res.add(p[1], p);
        }

        int[][] result = new int[people.length][2];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }
}