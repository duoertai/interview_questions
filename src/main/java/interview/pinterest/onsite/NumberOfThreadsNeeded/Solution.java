package interview.pinterest.onsite.NumberOfThreadsNeeded;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int getNumberOfThreads(String s, String target) {
        if(target.length() % s.length() != 0)
            return -1;

        int[] countS = new int[256];
        int[] countT = new int[256];
        for(int i = 0; i < s.length(); i++)
            countS[s.charAt(i)]++;
        for(int i = 0; i < target.length(); i++)
            countT[target.charAt(i)]++;

        int res = 0;
        for(int i = 0; i < 256; i++) {
            if(countS[i] == 0 && countT[i] == 0) {
                continue;
            } else if (countS[i] != 0 && countT[i] != 0) {
                if(res == 0) {
                    res = countT[i] / countS[i];
                } else if(res != countT[i] / countS[i]) {
                    return -1;
                }

            } else {
                return -1;
            }
        }

        List<Integer> index = new ArrayList<>();
        int i = 0;

        while(i < target.length()) {
            int next = -1;
            int j = 0;
            for(; j < index.size(); j++) {
                if(target.charAt(i) == s.charAt(index.get(j))) {
                    next = index.get(j);
                    break;
                }
            }

            if(next != -1) {
                next++;
                if(next < s.length()) {
                    index.set(j, next);
                }
            } else {
                if(target.charAt(i) != s.charAt(0))
                    return -1;
                else
                    index.add(1);
            }

            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfThreads("horse", "hhorrseose"));
    }
}
