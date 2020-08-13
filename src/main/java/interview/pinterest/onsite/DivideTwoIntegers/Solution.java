package interview.pinterest.onsite.DivideTwoIntegers;

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;


        long res = 0;
        int sign = 1;

        if(dividend < 0 && divisor > 0)
            sign = -1;
        if(dividend > 0 && divisor < 0)
            sign = -1;

        long numerator = dividend > 0 ? dividend : -1 *(long) dividend;
        long denominator = divisor > 0 ? divisor : -1 * (long) divisor;

        while(numerator >= denominator) {
            long num = 1;
            long temp = denominator;

            while(temp <= numerator) {
                temp = temp << 1;
                num = num << 1;
            }

            num = num >> 1;
            temp = temp >> 1;

            res += num;
            numerator -= temp;
        }

        res = res * sign;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return (int) res;
    }
}