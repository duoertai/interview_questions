package interview.pinterest.phone.IntervalListIntersections;

import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return new int[0][2];

        List<int[]> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int[] temp = new int[] {-1, -1};


        while(p1 < A.length && p2 < B.length) {
            int[] i1 = A[p1];
            int[] i2 = B[p2];

            if(i1[0] > i2[1]) {
                p2++;
            } else if(i2[0] > i1[1]) {
                p1++;
            } else {
                res.add(new int[] {
                        Math.max(i1[0], i2[0]),
                        Math.min(i1[1], i2[1])
                });

                if(i1[1] >= i2[1]) {
                    p2++;
                } else {
                    p1++;
                }
            }
        }

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}