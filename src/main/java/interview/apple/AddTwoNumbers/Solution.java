package interview.apple.AddTwoNumbers;

import interview.ListNode;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode p = fake;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;

        while(p1 != null || p2 != null) {
            int n1 = 0;
            if(p1 != null) {
                n1 = p1.val;
                p1 = p1.next;
            }

            int n2 = 0;
            if(p2 != null) {
                n2 = p2.val;
                p2 = p2.next;
            }

            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;

            p.next = new ListNode(sum);
            p = p.next;
        }

        if(carry == 1) {
            p.next = new ListNode(carry);
            p = p.next;
        }

        return fake.next;
    }
}
