package interview.pinterest.BasicCalculatorII;

class Solution {
    public int calculate(String s) {
        if(s == null)
            return 0;

        s = s.trim();
        if(s.length() == 0)
            return 0;

        int sum = 0;
        int sign = 1;
        int i = 0;
        int len = s.length();
        int part = 0;
        char op = '.';

        while(i < len){
            char c = s.charAt(i);

            if(c == '+') {
                sum += sign * part;
                part = 0;

                sign = 1;
                i++;
            } else if(c == '-') {
                sum += sign * part;
                part = 0;

                sign = -1;
                i++;
            } else if(c == '*') {
                op = '*';
                i++;
            } else if(c == '/') {
                op = '/';
                i++;
            } else if(c >= '0' && c <= '9') {
                int num = 0;
                int j = i;
                while(j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + (int) (s.charAt(j) - '0');
                    j++;
                }

                i = j;

                if(op == '*') {
                    part = part * num;
                }else if(op == '/') {
                    part = part / num;
                } else {
                    part = num;
                }

                op = '.';
            } else if(c == ' ') {
                i++;
            }
        }

        sum += sign * part;

        return sum;
    }
}