package interview.apple.ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().trim();

        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            while(left < right && !isAlphanumeric(str.charAt(left)))
                left++;
            while(left < right && !isAlphanumeric(str.charAt(right)))
                right--;

            if(left >= right)
                return true;

            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        if(c <= 'z' && c >= 'a')
            return true;
        if(c <= '9' && c >= '0')
            return true;

        return false;
    }
}