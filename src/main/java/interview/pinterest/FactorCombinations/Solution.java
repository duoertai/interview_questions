package interview.pinterest.FactorCombinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        if(n <= 3)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> line = new ArrayList<>();

        helper(res, line, 2, n);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> line, int start, int n) {

        if(n == 1) {
            if(line.size() > 1)
                res.add(new ArrayList<>(line));
            return;
        }


        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                line.add(i);
                helper(res, line, i, n / i);
                line.remove(line.size() - 1);
            }
        }
    }
}