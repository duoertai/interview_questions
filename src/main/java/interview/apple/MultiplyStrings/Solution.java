package interview.apple.MultiplyStrings;

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        String res = "0";

        for(int i = 0; i < num2.length(); i++) {
            int index = num2.length() - 1 - i;

            String temp = mul(num1, num2.charAt(index));
            for(int j = 0; j < i; j++)
                temp = temp + "0";
            res = add(res, temp);
        }

        return res;
    }

    public String mul(String num, char c) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int m = c - '0';
        for(int i = num.length() - 1; i >= 0; i--) {
            int n1 = num.charAt(i) - '0';
            int sum = (n1 * m + carry) % 10;
            carry = (n1 * m + carry) / 10;

            sb.insert(0, sum);
        }

        if(carry > 0)
            sb.insert(0, carry);

        return sb.toString();
    }

    public String add(String num1, String num2) {
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

        if(carry > 0)
            sb.insert(0, carry);

        return sb.toString();
    }
}