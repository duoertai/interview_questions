package interview.pinterest.phone.BasicCalculatorIII;

class Solution {
    public int calculate(String s) {
        if(s == null)
            return 0;

        s = s.trim();
        if(s.length() == 0)
            return 0;

        int sum = 0;
        int sign = 1;
        int part = 0;
        char op = '.';
        int i = 0;
        int len = s.length();

        while(i < len) {
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
                op = c;
                i++;
            }else if(c == '/') {
                op = c;
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
                } else if(op == '/') {
                    part = part / num;
                } else if(op == '.') {
                    part = num;
                }

                op = '.';
            } else if(c == ' ') {
                i++;
            } else if(c == '(') {
                int j = i + 1;
                int count = 1;
                while(j < len && count > 0) {
                    if(s.charAt(j) == '(')
                        count++;
                    else if(s.charAt(j) == ')')
                        count--;
                    j++;
                }

                j--;
                int num = calculate(s.substring(i + 1, j));

                if(op == '*') {
                    part = part * num;
                } else if(op == '/') {
                    part = part / num;
                } else if(op == '.') {
                    part = num;
                }

                op = '.';
                i = j + 1;
            }
        }

        sum += sign * part;

        return sum;
    }
}