package interview.pinterest.phone.NumberOfAtoms;

import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        if(formula == null || formula.length() == 0)
            return "";

        TreeMap<String, Integer> map = countAtoms(formula);
        StringBuilder sb = new StringBuilder();
        for(String key: map.keySet()) {
            if(map.get(key) > 1)
                sb.append(key).append(map.get(key));
            else
                sb.append(key);
        }

        return sb.toString();
    }

    private TreeMap<String, Integer> countAtoms(String formula) {
        TreeMap<String, Integer> res = new TreeMap<String, Integer>();
        int i = 0;
        while(i < formula.length()) {
            char c = formula.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                int j = i + 1;
                if(j == formula.length() || (j < formula.length() && formula.charAt(j) >= 'A' && formula.charAt(j) <= 'Z') || (j < formula.length() && formula.charAt(j) == '(')) {
                    String atom = "" + c;
                    if(!res.containsKey(atom))
                        res.put(atom, 1);
                    else
                        res.put(atom, res.get(atom) + 1);
                } else if(formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') {
                    String atom = "" + c;
                    while(j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') {
                        atom = atom + formula.charAt(j);
                        j++;
                    }

                    if(j == formula.length() || (j < formula.length() && formula.charAt(j) >= 'A' && formula.charAt(j) <= 'Z') || (j < formula.length() && formula.charAt(j) == '(')) {
                        if(!res.containsKey(atom))
                            res.put(atom, 1);
                        else
                            res.put(atom, res.get(atom) + 1);
                    } else {
                        int num = 0;
                        while(j < formula.length() && formula.charAt(j) >= '0' && formula.charAt(j) <= '9') {
                            num = num * 10 + (int) (formula.charAt(j) - '0');
                            j++;
                        }
                        if(!res.containsKey(atom))
                            res.put(atom, num);
                        else
                            res.put(atom, res.get(atom) + num);
                    }
                } else if(formula.charAt(j) >= '0' && formula.charAt(j) <= '9') {
                    String atom = "" + c;
                    int num = 0;
                    while(j < formula.length() && formula.charAt(j) >= '0' && formula.charAt(j) <= '9') {
                        num = num * 10 + (int) (formula.charAt(j) - '0');
                        j++;
                    }
                    if(!res.containsKey(atom))
                        res.put(atom, num);
                    else
                        res.put(atom, res.get(atom) + num);
                }

                i = j;
            } else if(formula.charAt(i) == '(') {
                int count = 1;
                int j = i + 1;

                while(j < formula.length() && count > 0) {
                    if(formula.charAt(j) == '(')
                        count++;
                    else if(formula.charAt(j) == ')')
                        count--;
                    j++;
                }
                j--;
                String sub = formula.substring(i + 1, j);
                TreeMap<String, Integer> subRes = countAtoms(sub);

                j++;
                if(formula.charAt(j) >= 'A' && formula.charAt(j) <= 'Z') {
                    for(String key: subRes.keySet()) {
                        if(res.containsKey(key))
                            res.put(key, res.get(key) + subRes.get(key));
                        else
                            res.put(key, subRes.get(key));
                    }
                } else if(formula.charAt(j) >= '0' && formula.charAt(j) <= '9') {
                    int num = 0;
                    while(j < formula.length() && formula.charAt(j) >= '0' && formula.charAt(j) <= '9') {
                        num = num * 10 + (int) (formula.charAt(j) - '0');
                        j++;
                    }

                    for(String key: subRes.keySet()) {
                        if(res.containsKey(key))
                            res.put(key, res.get(key) + subRes.get(key) * num);
                        else
                            res.put(key, subRes.get(key) * num);
                    }
                }
                i = j;
            }
        }

        return res;
    }
}