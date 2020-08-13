package interview.pinterest.onsite.CopyListWithRandomPointer;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.*;

class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        return copy(map, head);
    }

    private Node copy(Map<Node, Node> map, Node head) {
        if(head == null)
            return null;

        if(map.containsKey(head))
            return map.get(head);

        Node c = new Node(head.val);
        map.put(head, c);
        c.next = copy(map, head.next);
        c.random = copy(map, head.random);
        return c;
    }
}