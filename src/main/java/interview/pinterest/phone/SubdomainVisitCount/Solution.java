package interview.pinterest.phone.SubdomainVisitCount;

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length == 0)
            return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String s: cpdomains) {
            String[] strs = s.split("\\s");
            Integer times = Integer.parseInt(strs[0]);

            String[] components = strs[1].split("\\.");
            String domain = "";

            for(int i = components.length - 1; i >= 0; i--) {
                if(domain.length() == 0) {
                    domain = components[i];
                } else {
                    domain = components[i] + "." + domain;
                }

                if(!map.containsKey(domain)) {
                    map.put(domain, times);
                } else {
                    map.put(domain, map.get(domain) + times);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(String domain: map.keySet()) {
            res.add("" + map.get(domain) + " " + domain);
        }

        return res;
    }
}