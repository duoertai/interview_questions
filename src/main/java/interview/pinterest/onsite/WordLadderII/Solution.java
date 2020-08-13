package interview.pinterest.onsite.WordLadderII;

import java.util.*;

class Solution {
    public class Node {
        public String str;
        public Node prev;

        public Node(String str) {
            this.str = str;
            this.prev = null;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return res;

        LinkedList<Node> curr = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        boolean found = false;

        curr.offer(new Node(beginWord));
        List<Node> end = new ArrayList<>();

        while(curr.size() > 0) {
            Node temp = curr.poll();
            String t = temp.str;
            visited.add(t);

            if(t.equals(endWord)) {
                found = true;
                end.add(temp);
            }

            char[] cs = t.toCharArray();
            for(int i = 0; i < cs.length; i++) {
                char origin = cs[i];

                for(char c = 'a'; c <= 'z'; c++) {
                    if(c != origin) {
                        cs[i] = c;
                        String str = String.valueOf(cs);
                        if(!visited.contains(str) && dict.contains(str)) {
                            Node n = new Node(str);
                            n.prev = temp;
                            next.offer(n);
                        }
                    }
                }

                cs[i] = origin;
            }

            if(curr.size() == 0) {
                if(found)
                    break;

                curr = next;
                next = new LinkedList<>();
            }
        }

        for(Node n: end) {
            List<String> line = new ArrayList<>();
            while(n != null) {
                line.add(n.str);
                n = n.prev;
            }
            Collections.reverse(line);
            res.add(line);
        }

        return res;
    }
}