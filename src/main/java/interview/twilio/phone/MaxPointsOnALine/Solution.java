package interview.twilio.phone.MaxPointsOnALine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if(points == null || points.length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                if(i1[0] != i2[0])
                    return i1[0] - i2[0];
                else
                    return i1[1] - i2[1];
            }
        });

        int max = 0;

        for(int i = 0; i < points.length; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            int dup = 1;
            int vertical = 0;

            for(int j = i + 1; j < points.length; j++) {

                int deltax = points[j][0] - points[i][0];
                int deltay = points[j][1] - points[i][1];


                if(deltax == 0 && deltay == 0) {
                    dup++;
                } else if(deltax == 0) {
                    vertical++;
                } else {
                    int gcd = getGCD(deltax, deltay);
                    if(gcd != 0) {
                        deltax /= gcd;
                        deltay /= gcd;
                    }

                    if(!map.containsKey(deltax))
                        map.put(deltax, new HashMap<>());
                    if(!map.get(deltax).containsKey(deltay))
                        map.get(deltax).put(deltay, 1);
                    else
                        map.get(deltax).put(deltay, map.get(deltax).get(deltay) + 1);
                }
            }

            max = Math.max(max, vertical + dup);

            for(Integer x: map.keySet()) {
                for(Integer v: map.get(x).values())
                    max = Math.max(max, dup + v);
            }
        }


        return max;
    }

    private int getGCD(int a, int b) {
        if(b == 0)
            return a;
        return getGCD(b, a % b);
    }
}