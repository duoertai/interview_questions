package interview.twilio.phone.KnightDialer;

import java.util.*;

public class Solution {
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    static {
        map.put(0, Arrays.asList(4, 6));
        map.put(1, Arrays.asList(6, 8));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(4, 8));
        map.put(4, Arrays.asList(0, 3, 9));
        map.put(5, new ArrayList<>());
        map.put(6, Arrays.asList(0, 1, 7));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(2, 4));
    }

    public int knightDialer(int N) {
        if(N == 0)
            return 0;

        long[][] count = new long[N][10];
        for(int i = 0; i < 10; i++) {
            count[0][i] = 1;
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < 10; j++) {
                List<Integer> next = map.get(j);
                for(Integer n: next) {
                    // avoid overflow
                    count[i + 1][n] += count[i][j] % 1000000007;
                    count[i + 1][n] %= 1000000007;
                    if (count[i + 1][n] < 0)
                        count[i + 1][n] += 1000000007;
                }
            }
        }

        long res = 0;
        for(int i = 0; i < 10; i++) {
            // avoid overflow
            res += count[N - 1][i] % 1000000007;
            res %= 1000000007;
            if (res < 0)
                res += 1000000007;
        }

        return (int) res;
    }
}
