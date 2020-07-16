package interview.twilio.LongestPrefixMatch;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    // for simplicity, should be a separate class in another file
    static class TrieNode{
        // for simplicity, skipping getters, setters, etc
        public Map<Character, TrieNode> children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String s) {
            char[] cs = s.toCharArray();
            TrieNode p = root;
            for(int i = 0; i < cs.length; i++) {
                if(!p.children.containsKey(cs[i])){
                    p.children.put(cs[i], new TrieNode());
                }
                p = p.children.get(cs[i]);
            }
            p.isEnd = true;
        }

        public String findLongestPrefix(String word) {
            StringBuilder sb = new StringBuilder("");
            String res = "";

            TrieNode p = root;
            for(int i = 0; i < word.length(); i++) {
                if (!p.children.containsKey(word.charAt(i))) {
                    break;
                } else {
                    p = p.children.get(word.charAt(i));
                    sb.append(word.charAt(i));
                    if (p.isEnd) {
                        res = sb.toString();
                    }
                }
            }

            return res;
        }
    }

    public static String[] findLongestPrefixMatch(String[] areaCodes, String[] numbers) {
        String[] res = new String[numbers.length];
        Trie trie = new Trie();
        for(String areaCode: areaCodes) {
            trie.addWord(areaCode);
        }

        for(int i = 0; i < numbers.length; i++) {
            res[i] = trie.findLongestPrefix(numbers[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] res = Solution.findLongestPrefixMatch(
                new String[] {"+123", "+12", "+1"},
                new String[] {"+1234", "+124", "+3"}
        );

        for(String s: res)
            System.out.println(s);
    }
}
