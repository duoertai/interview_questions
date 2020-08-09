package interview.pinterest.phone.ImplementTrie;

class Trie {
    class Node {
        public Node[] children;
        public boolean isEnd;

        public Node() {
            this.children = new Node[26];
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = this.root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(p.children[c - 'a'] == null)
                p.children[c - 'a'] = new Node();

            p = p.children[c - 'a'];
        }

        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = this.root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(p.children[c - 'a'] == null)
                return false;

            p = p.children[c - 'a'];
        }

        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if(p.children[c - 'a'] == null)
                return false;

            p = p.children[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
