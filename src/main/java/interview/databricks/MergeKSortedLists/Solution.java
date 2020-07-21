package interview.databricks.MergeKSortedLists;

import interview.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

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

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                queue.offer(lists[i]);
        }

        ListNode res = new ListNode(0);
        ListNode p = res;

        while(queue.size() != 0) {
            ListNode temp = queue.poll();
            p.next = temp;
            p = p.next;

            if(temp.next != null)
                queue.offer(temp.next);
        }

        return res.next;
    }
}