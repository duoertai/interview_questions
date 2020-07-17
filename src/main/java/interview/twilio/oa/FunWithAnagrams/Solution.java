package interview.twilio.FunWithAnagrams;

import com.google.common.collect.ImmutableList;

import java.util.*;


// constraints
// text[i] < 1000
// char ascii[a-z]
public class Solution {
    private static final int ALPHABET_SIZE = 26;

    public static List<String> funWithAnagrams(List<String> text) {
        if(text == null || text.size() <= 1)
            return text;

        Set<String> customHashSet = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(String t: text) {
            String customHash = getCustomHash(t);
            if (!customHashSet.contains(customHash)) {
                res.add(t);
                customHashSet.add(customHash);
            }
        }

        Collections.sort(res);

        return res;
    }

    private static String getCustomHash(String s) {
        if (s == null)
            return "";
        int[] count = new int[ALPHABET_SIZE];
        char[] cs = s.toCharArray();

        for(int i = 0; i < cs.length; i++) {
            count[cs[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ALPHABET_SIZE; i++) {
            if(count[i] != 0)
                sb.append((char) ('a' + i)).append(count[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> res = Solution.funWithAnagrams(ImmutableList.<String>of("framer", "frame", "code", "doce", "ecod"));
        for (String s: res) {
            System.out.print(s + " ");
        }
    }
}
