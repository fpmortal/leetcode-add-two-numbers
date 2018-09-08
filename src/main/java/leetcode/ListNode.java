package leetcode;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : " -> " + next);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ListNode) {
            final ListNode that = (ListNode) object;

            boolean remainder;
            if (this.next == null) {
                remainder = that.next == null;
            } else {
                remainder = this.next.equals(that.next);
            }

            return this.val == that.val && remainder;
        } else {
            return false;
        }
    }
}
