package leetcode;

public class Solution {

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        final ListNode head = new ListNode(0);
        ListNode c = head;

        while (a != null || b != null) {
            if (a == null) {
                a = new ListNode(0);
            } else if (b == null) {
                b = new ListNode(0);
            }

            c.val += a.val + b.val;

            if (c.val >= 10) {
                c.val -= 10;
                c.next = new ListNode(1);
            } else {
                if (a.next != null || b.next != null) {
                    c.next = new ListNode(0);
                }
            }

            a = a.next;
            b = b.next;
            c = c.next;
        }

        return head;
    }
}
