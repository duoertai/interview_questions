package interview.pinterest.phone.LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        int min = Integer.MAX_VALUE;
        for(String str: strs)
            min = Math.min(min, str.length());

        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < min; i++){
            char c = strs[0].charAt(i);

            int j = 1;
            for(; j < strs.length; j++){
                if(strs[j].charAt(i) != c)
                    break;
            }

            if(j == strs.length)
                sb.append(c);
            else
                break;
        }

        return sb.toString();
    }
}