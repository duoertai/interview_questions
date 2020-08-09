package interview.pinterest.onsite.RunLengthEncoding;

public class Solution {
    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            int count = 0;

            while(j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
                count++;
            }

            int len = getNumLength(count);
            sb.append(str.charAt(i)).append(len).append('0').append(count);

            i = j;
        }

        return sb.toString();
    }

    private static int getNumLength(int n) {
        int len = 0;
        while(n > 0) {
            n /= 10;
            len++;
        }

        return len;
    }

    public static String decode(String str) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < str.length()) {
            int j = i;
            // find char
            char c = str.charAt(j);
            // find length of run length
            i++;
            j++;
            while(j < str.length() && str.charAt(j) != '0')
                j++;
            while(j < str.length() && str.charAt(j) == '0')
                j++;
            int len = Integer.parseInt(str.substring(i, j - 1));
            // find run length
            int count = Integer.parseInt(str.substring(j, j + len));
            for(int k = 0; k < count; k++) {
                sb.append(c);
            }

            i = j + len;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "111111111122222aaaaaaaaaa444444444333332666666666";
        System.out.println(decode(encode(s)).equals(s));
    }
}
