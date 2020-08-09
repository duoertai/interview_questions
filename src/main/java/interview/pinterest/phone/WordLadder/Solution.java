package interview.pinterest.phone.WordLadder;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        LinkedList<String> curr = new LinkedList<>();
        LinkedList<String> next = new LinkedList<>();
        int level = 1;
        curr.offer(beginWord);

        while(curr.size() > 0) {
            String temp = curr.poll();
            if(temp.equals(endWord))
                return level;

            char[] cs = temp.toCharArray();

            for(int i = 0; i < cs.length; i++) {
                char original = cs[i];

                for(char c = 'a'; c <= 'z'; c++) {
                    if(c != original) {
                        cs[i] = c;
                        String s = String.valueOf(cs);
                        if(set.contains(s)) {
                            next.offer(s);
                            set.remove(s);
                        }
                    }
                }
                cs[i] = original;
            }

            if(curr.size() == 0){
                curr = next;
                next = new LinkedList<>();
                level++;
            }
        }

        return 0;
    }
}