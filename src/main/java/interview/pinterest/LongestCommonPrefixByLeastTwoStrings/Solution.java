package interview.pinterest.LongestCommonPrefixByLeastTwoStrings;

import java.util.*;

public class Solution {
    static class Node {
        public Map<Character, Node> children;
        public int leavesNum;
        public boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
            this.leavesNum = 0;
            this.isEnd = false;
        }
    }

    static class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node p = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                p.leavesNum++;

                if(!p.children.containsKey(c))
                    p.children.put(c, new Node());
                p = p.children.get(c);
            }

            p.leavesNum++;
            p.isEnd = true;
        }

        public String findLongestCommonPrefix() {
            StringBuilder sb = new StringBuilder();

            helper(root, "", sb);

            return sb.toString();
        }

        private void helper(Node root, String temp, StringBuilder sb) {
            if(root.leavesNum < 2)
                return;

            if(temp.length() > sb.length()) {
                sb.setLength(0);
                sb.append(temp);
            }

            for(Character c: root.children.keySet()) {
                helper(root.children.get(c), temp + c, sb);
            }
        }
    }

    public static String getLongestCommonPrefix(List<String> words) {
        Trie trie = new Trie();
        for(String w: words)
            trie.addWord(w);

        return trie.findLongestCommonPrefix();
    }

    public static void main(String[] args) {
        System.out.println(getLongestCommonPrefix(new ArrayList<>(Arrays.asList(
                "abcdefg",
                "aaaaa",
                "abcde",
                "abcdeffffffff",
                "abkkk",
                "bds",
                "fff"
        ))));
    }
}
