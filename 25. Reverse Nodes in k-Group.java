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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode tail = dummy;

        while (true) {
            int count = k;
            while (count > 0 && tail != null) {
                tail = tail.next;
                count--;
            }
            if (tail == null) {
                break;
            }
            head = prev.next;
            while (prev.next != tail) {
                curr = prev.next;
                prev.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }
}
