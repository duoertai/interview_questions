package interview.apple.MergeKSortedLists;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for(ListNode head: lists)
            if(head != null)
                queue.offer(head);

        ListNode fake = new ListNode(0);
        ListNode p = fake;
        while(queue.size() > 0) {
            ListNode node = queue.poll();

            p.next = node;
            p = p.next;
            if(node.next != null)
                queue.offer(node.next);
        }

        return fake.next;
    }
}
