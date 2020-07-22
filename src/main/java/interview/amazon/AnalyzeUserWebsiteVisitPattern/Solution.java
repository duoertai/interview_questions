package interview.amazon.AnalyzeUserWebsiteVisitPattern;

import java.util.*;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Object[]>> history = new HashMap<>();
        int n = username.length;

        for(int i = 0; i < n; i++) {
            if(!history.containsKey(username[i]))
                history.put(username[i], new ArrayList<>());
            history.get(username[i]).add(new Object[] {website[i], timestamp[i]});
        }

        Map<String, Set<String>> patterns = new HashMap<>();

        for(String user: history.keySet()) {
            List<Object[]> records = history.get(user);
            Collections.sort(records, new Comparator<Object[]>(){
                public int compare(Object[] o1, Object[] o2) {
                    return (Integer) o1[1] - (Integer)o2[1];
                }
            });

            recordPattern(patterns, records, user);
        }

        int max = 0;
        String resPattern = "";
        for(String pattern: patterns.keySet()) {
            if(patterns.get(pattern).size() > max) {
                max = patterns.get(pattern).size();
                resPattern = pattern;
            } else if(patterns.get(pattern).size() == max) {
                if(pattern.compareTo(resPattern) < 0)
                    resPattern = pattern;
            }
        }

        return Arrays.asList(resPattern.split(":"));
    }

    private void recordPattern(Map<String, Set<String>> patterns, List<Object[]> records, String user) {
        int n = records.size();
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    String pattern = (String) records.get(i)[0] + ":" + (String) records.get(j)[0] + ":" + (String) records.get(k)[0];

                    if(!patterns.containsKey(pattern)) {
                        patterns.put(pattern, new HashSet<String>());
                    }
                    patterns.get(pattern).add(user);
                }
            }
        }
    }
}