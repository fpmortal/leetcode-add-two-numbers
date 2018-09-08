package leetcode;

public class Solution {

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        final ListNode c = new ListNode(a.val + b.val);

        ListNode c1 = c;
        a = a.next;
        b = b.next;

        boolean dec = false;
        while (a != null || b != null) {
            if (a == null) {
                a = new ListNode(0);
            } else if (b == null) {
                b = new ListNode(0);
            }

            if (c1.val >= 10) {
                dec = true;
                c1.val -= 10;
            }

            c1.next = new ListNode(a.val + b.val);
            c1 = c1.next;

            if (dec) {
                c1.val += 1;
                dec = false;
            }

            a = a.next;
            b = b.next;
        }

        if (c1.val >= 10) {
            c1.val -= 10;
            c1.next = new ListNode(1);
        }

        return c;
    }
}
