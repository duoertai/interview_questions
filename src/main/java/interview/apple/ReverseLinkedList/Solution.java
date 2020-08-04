package interview.apple.ReverseLinkedList;

import interview.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

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
