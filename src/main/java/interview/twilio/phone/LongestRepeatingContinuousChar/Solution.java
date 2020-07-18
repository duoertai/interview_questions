package interview.twilio.phone.LongestRepeatingContinuousChar;

public class Solution {
    public static Character getLongestRepeatingContinuousChar(String str) {
        if (str == null || str.length() == 0)
            return null;

        char res = str.charAt(0);
        int max = 1;

        char curr = str.charAt(0);
        int len = 1;

        for(int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == curr) {
                len++;
            } else {
                if (len > max) {
                    max = len;
                    res = curr;
                }

                curr = c;
                len = 1;
            }
        }

        if (len > max) {
            max = len;
            res = curr;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.getLongestRepeatingContinuousChar("AABBCCCCCBABAAAAAA"));
    }
}
