package interview.apple.LRUCache;

import java.util.*;

class LRUCache {
    class Node {
        public Node next;
        public Node prev;
        public int key;
        public int value;

        public Node(int key, int value) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public void moveToHead(Node node) {
        node.next = this.head.next;
        head.next.prev = node;
        node.prev = head;
        this.head.next = node;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        int res = node.value;
        remove(node);
        moveToHead(node);
        return res;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            moveToHead(node);
        } else {
            if(this.map.size() < this.capacity) {
                Node node = new Node(key, value);
                moveToHead(node);
                this.map.put(key, node);
            } else {
                this.map.remove(this.tail.prev.key);
                remove(this.tail.prev);
                Node node = new Node(key, value);
                moveToHead(node);
                this.map.put(key, node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */