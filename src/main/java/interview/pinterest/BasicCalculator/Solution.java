package interview.pinterest.BasicCalculator;

class Solution {
    public int calculate(String s) {
        s = s.trim();
        if(s == null || s.length() == 0)
            return 0;

        int sum = 0;
        int sign = 1;
        int i = 0;

        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '+') {
                sign = 1;
                i++;
            } else if(c == '-') {
                sign = -1;
                i++;
            } else if(c == ' ') {
                i++;
            } else if(c >= '0' && c <= '9') {
                int j = i;
                int num = 0;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + (int) (s.charAt(j) - '0');
                    j++;
                }

                sum += sign * num;
                i = j;
            } else if(c == '(') {
                int count = 1;
                int j = i + 1;
                while(j < s.length() && count > 0) {
                    if(s.charAt(j) == '(')
                        count++;
                    else if(s.charAt(j) == ')')
                        count--;
                    j++;
                }
                j--;

                int num = calculate(s.substring(i + 1, j));
                sum += sign * num;
                i = j + 1;
            }
        }

        return sum;
    }
}
