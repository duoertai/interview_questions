package interview.twilio.StockAnalysis;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void stockAnalysis(List<List<String>> sources) {
        Map<String, String> map = new LinkedHashMap<>();
        for (List<String> source: sources) {
            for (String s: source) {
                String param = s.split(":")[0];
                String value = s.split(":")[1];

                map.put(param, value);
            }
        }

        for(String param: map.keySet()) {
            System.out.println(map.get(param));
        }
    }

    public static void main(String[] args) {
        Solution.stockAnalysis(
                ImmutableList.of(
                        ImmutableList.of("P1:x", "P2:y", "P5:z"),
                        ImmutableList.of("P1:b", "P5:a", "P3:w")
                )
        );
    }
}
