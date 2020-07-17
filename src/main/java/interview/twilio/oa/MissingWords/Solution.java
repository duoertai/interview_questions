package interview.twilio.oa.MissingWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> findMissingWord(String t, String s) {
        String[] tWords = t.trim().split("\\s+");
        String[] sWords = s.trim().split("\\s+");

        int tIndex = 0;
        List<String> res = new ArrayList<>();

        for(int i = 0; i < sWords.length; i++) {
            if (tIndex == tWords.length) {
                res.add(sWords[i]);
            }
            else if (sWords[i].equals(tWords[tIndex])) {
                tIndex++;
            } else {
                res.add(sWords[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> res = Solution.findMissingWord(
                "am hackerrank to improve",
                "I am using hackerrank to improve programming"
        );

        for (String s: res)
            System.out.println(s);
    }
}
