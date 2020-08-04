package interview.apple.StringToInteger;

class Solution {
    public int myAtoi(String str) {
        if(str == null || str.trim().length() == 0)
            return 0;

        str = str.trim();
        char c = str.charAt(0);
        if(c != '+' && c != '-' && !(c <= '9' && c >= '0'))
            return 0;

        long res = 0;
        int sign = 1;
        int i = 0;
        if(c == '-') {
            sign = -1;
            i = 1;
        } else if(c == '+') {
            i = 1;
        }

        while(i < str.length()) {
            c = str.charAt(i);
            if(c <= '9' && c >= '0') {
                res = res * 10 + (int) (c - '0');
                if(sign * res >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

                if(sign * res <= Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;

                i++;
            } else {
                return (int) (sign * res);
            }
        }

        return (int) (sign * res);
    }
}
