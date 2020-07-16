package interview.twilio.SmsSplitting;

import java.util.ArrayList;
import java.util.List;

// segment message into chunks of 160 chars and add suffix like (1/5) (2/5)
// input constraints:
// word separated by single space
// after splitting, there will less than 10 pages
public class Solution {
    private static final int SEGMENT_LENGTH = 160;
    private static final String SPACE = " ";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    private static final String SLASH = "/";

    public static List<String> splitTextBySmsStandard(String text) {
        if (text == null) {
            return new ArrayList<>();
        }
        if (text.length() <= SEGMENT_LENGTH) {
            List<String> res = new ArrayList<>();
            res.add(text);
            return res;
        }

        List<StringBuilder> initSegments = initialize(text);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < initSegments.size(); i++) {
            String s = initSegments.get(i).append(LEFT_BRACKET).append(i + 1).append(SLASH).append(initSegments.size()).append(RIGHT_BRACKET).toString();
            res.add(s);
        }

        return res;
    }

    private static List<StringBuilder> initialize(String text) {
        text = text.trim();
        List<StringBuilder> stringBuilders = new ArrayList<>();
        stringBuilders.add(new StringBuilder());

        String[] words = text.split("\\s+");
        String[] wordsWithSpace = new String[words.length * 2 - 1];
        for(int i = 0; i < words.length - 1; i++) {
            wordsWithSpace[2 * i] = words[i];
            wordsWithSpace[2 * i + 1] = SPACE;
        }

        wordsWithSpace[2 * words.length - 2] = words[words.length - 1];

        int len = 0;

        for(String word: wordsWithSpace) {
            StringBuilder sb = stringBuilders.get(stringBuilders.size() - 1);
            if (sb.length() + word.length() <= SEGMENT_LENGTH - 5) {
                sb.append(word);
                len += word.length();
            } else {
                stringBuilders.add(new StringBuilder());
                StringBuilder next = stringBuilders.get(stringBuilders.size() - 1);
                len = word.length();
                next.append(word);
            }
        }

        return stringBuilders;
    }

    public static void main(String[] args) {
        List<String> res = Solution.splitTextBySmsStandard("njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg");
        for (String s: res)
            System.out.println(s);
    }
}
