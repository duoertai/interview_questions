package interview.pinterest.onsite.WordLadder;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;
        LinkedList<String> curr = new LinkedList<>();
        LinkedList<String> next = new LinkedList<>();
        int level = 1;
        curr.offer(beginWord);

        while(curr.size() > 0) {
            String word = curr.poll();
            visited.add(word);

            if(word.equals(endWord))
                return level;

            char[] cs = word.toCharArray();
            for(int i = 0; i < cs.length; i++) {
                char origin = cs[i];

                for(char c = 'a'; c <= 'z'; c++) {
                    if(c != origin) {
                        cs[i] = c;

                        String str = String.valueOf(cs);
                        if(!visited.contains(str) && dict.contains(str)) {
                            next.offer(str);
                        }
                    }
                }

                cs[i] = origin;
            }

            if(curr.size() == 0) {
                curr = next;
                next = new LinkedList<>();
                level++;
            }
        }

        return 0;
    }
}