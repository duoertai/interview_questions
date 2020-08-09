package interview.pinterest.phone.BlacklistWords;

import java.util.*;

public class Solution {
    static class Node {
        public Map<String, Node> children;
        public boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    static class Tree {
        public Node root;
        public Tree() {
            this.root = new Node();
        }

        public void addWords(String[] words) {
            Node p = root;
            for(int i = 0; i < words.length; i++) {
                if(!p.children.containsKey(words[i]))
                    p.children.put(words[i], new Node());
                p = p.children.get(words[i]);
            }

            p.isEnd = true;
        }

        public boolean find(String s) {
            String[] words = s.split("\\s+");
            for(int i = 0; i < words.length; i++) {
                Node p = root;
                if(p.children.containsKey(words[i])) {
                    int j = i;
                    while (j < words.length) {
                        if(p.isEnd)
                            return true;
                        if(p.children.containsKey(words[j])) {
                            p = p.children.get(words[j]);
                            j++;
                        } else {
                            break;
                        }
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("world war i");
        set.add("world war ii");

        Tree tree = new Tree();
        for(String s: set) {
            String[] strs = s.split("\\s+");
            tree.addWords(strs);
        }
        System.out.println(tree.find("world war i is happening"));
    }
}
