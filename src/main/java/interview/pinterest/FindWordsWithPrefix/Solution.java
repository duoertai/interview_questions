package interview.pinterest.FindWordsWithPrefix;

import java.util.*;

public class Solution {
    static class Node {
        public Map<Character, Node> children;
        public boolean isEnd;
        public String str;

        public Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
            this.str = null;
        }
    }

    static class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void addWord(String s) {
            Node p = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(!p.children.containsKey(c))
                    p.children.put(c, new Node());
                p = p.children.get(c);
            }
            p.isEnd = true;
            p.str = s;
        }

        public List<String> findWordsWithPrefix(String prefix) {
            Node p = root;

            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(!p.children.containsKey(c))
                    return new ArrayList<>();
                p = p.children.get(c);
            }

            List<String> res = new ArrayList<>();
            helper(res, p);

            return res;
        }

        private void helper(List<String> res, Node p) {
            if(p == null)
                return;

            if(p.isEnd)
                res.add(p.str);

            for(Node n: p.children.values())
                helper(res, n);
        }
    }

    public static List<String> findWordsWithPrefix(List<String> words, String prefix) {
        Trie trie = new Trie();
        for(String w: words)
            trie.addWord(w);

        return trie.findWordsWithPrefix(prefix);
    }

    public static void main(String[] args) {
        List<String> res = findWordsWithPrefix(Arrays.asList("aaabb", "ab", "12", "abg"), "ab");
        for(String s: res)
            System.out.println(s);
    }
}
