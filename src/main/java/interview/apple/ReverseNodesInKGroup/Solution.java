package interview.apple.ReverseNodesInKGroup;

import interview.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;

        List<ListNode> heads = new ArrayList<>();
        ListNode p1 = head;
        boolean last = true;
        while(p1 != null) {
            ListNode p2 = p1;
            for(int i = 0; i < k - 1 && p2 != null; i++)
                p2 = p2.next;

            if(p2 == null) {
                heads.add(p1);
                p1 = p2;
                last = false;
            } else {
                heads.add(p1);
                p1 = p2.next;
                p2.next = null;
            }
        }

        for(int i = 0; i < heads.size() - 1; i++) {
            heads.set(i, reverse(heads.get(i)));
        }

        if(last) {
            heads.set(heads.size() - 1, reverse(heads.get(heads.size() - 1)));
        }

        ListNode fake = new ListNode(0);
        ListNode p = fake;

        for(ListNode l: heads) {
            p.next = l;
            while(p.next != null)
                p = p.next;
        }

        return fake.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;
    }
}
