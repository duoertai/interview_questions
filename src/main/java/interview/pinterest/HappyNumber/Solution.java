package interview.pinterest.HappyNumber;

import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 0) {
            if(n == 1)
                return true;
            if(set.contains(n))
                return false;

            set.add(n);

            int next = 0;
            while(n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }

            n = next;
        }

        return false;
    }
}
