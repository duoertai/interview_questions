package interview.apple.AddStrings;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        while(p1 >= 0 || p2 >= 0) {
            int n1 = 0;
            if(p1 >= 0) {
                n1 = num1.charAt(p1) - '0';
                p1--;
            }

            int n2 = 0;
            if(p2 >= 0) {
                n2 = num2.charAt(p2) - '0';
                p2--;
            }

            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;

            sb.insert(0, sum);
        }

        if(carry == 1)
            sb.insert(0, 1);

        return sb.toString();
    }
}