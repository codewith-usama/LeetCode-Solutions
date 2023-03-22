/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // If first pointer reaches end, remove the head node
        if (first == null) {
            head = head.next;
            return head;
        }

        // Move both pointers until first pointer reaches end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        return head;
    }
}
