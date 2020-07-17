package interview.twilio.phone.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;

        public Node(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = tail;
        this.tail.prev = head;
    }

    private void moveToFront(Node n) {
        remove(n);
        insertToFront(n);
    }

    private void insertToFront(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node target = map.get(key);
        int res = target.value;
        moveToFront(target);
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            target.value = value;
            moveToFront(target);
        } else {
            Node target = new Node(key, value);
            if (map.size() < capacity) {
                map.put(key, target);
                insertToFront(target);
            } else {
                Node n = tail.prev;
                remove(n);
                map.remove(n.key);
                map.put(key, target);
                insertToFront(target);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
