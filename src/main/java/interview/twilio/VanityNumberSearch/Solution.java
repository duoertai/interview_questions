package interview.twilio.VanityNumberSearch;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.*;

// example: FLOWERS -> 3569377
// numbers contains this vanity code 1-800-3569377
public class Solution {
    private static final Map<String, String> LETTER_DIGIT_MAPPING = new HashMap<>();

    static {
        LETTER_DIGIT_MAPPING.put("A", "2");
        LETTER_DIGIT_MAPPING.put("B", "2");
        LETTER_DIGIT_MAPPING.put("C", "2");
        LETTER_DIGIT_MAPPING.put("D", "3");
        LETTER_DIGIT_MAPPING.put("E", "3");
        LETTER_DIGIT_MAPPING.put("F", "3");
        LETTER_DIGIT_MAPPING.put("G", "4");
        LETTER_DIGIT_MAPPING.put("H", "4");
        LETTER_DIGIT_MAPPING.put("I", "4");
        LETTER_DIGIT_MAPPING.put("J", "5");
        LETTER_DIGIT_MAPPING.put("K", "5");
        LETTER_DIGIT_MAPPING.put("L", "5");
        LETTER_DIGIT_MAPPING.put("M", "6");
        LETTER_DIGIT_MAPPING.put("N", "6");
        LETTER_DIGIT_MAPPING.put("O", "6");
        LETTER_DIGIT_MAPPING.put("P", "7");
        LETTER_DIGIT_MAPPING.put("Q", "7");
        LETTER_DIGIT_MAPPING.put("R", "7");
        LETTER_DIGIT_MAPPING.put("S", "7");
        LETTER_DIGIT_MAPPING.put("T", "8");
        LETTER_DIGIT_MAPPING.put("U", "8");
        LETTER_DIGIT_MAPPING.put("V", "8");
        LETTER_DIGIT_MAPPING.put("W", "9");
        LETTER_DIGIT_MAPPING.put("X", "9");
        LETTER_DIGIT_MAPPING.put("Y", "9");
        LETTER_DIGIT_MAPPING.put("Z", "9");
    }

    public static List<String> findNumbersWithVanityCode(List<String> code, List<String> numbers) {
        Set<String> numberSegments = translateCode(code);
        Set<String> resSet = new HashSet<>();

        for (String n: numberSegments) {
            for(String s: numbers) {
                if (s.contains(n))
                    resSet.add(s);
            }
        }

        List<String> res = new ArrayList<>(resSet);

        Collections.sort(res);
        return res;
    }

    private static Set<String> translateCode(List<String> code) {
        Set<String> set = new HashSet<>();
        for (String s: code) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                sb.append(LETTER_DIGIT_MAPPING.get(s.substring(i, i + 1)));
            }
            set.add(sb.toString());
        }

        return set;
    }

    public static void main(String[] args) {
        List<String> res = Solution.findNumbersWithVanityCode(
                ImmutableList.of("FLOWERS"),
                ImmutableList.of("1-800-3569377")
        );

        for (String s: res)
            System.out.println(s);
    }
}
