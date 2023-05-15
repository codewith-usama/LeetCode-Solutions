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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode x = head, y = head, t = head;

        // Until we reach k-th node from the beginning
        while (k > 1) {
            x = x.next;
            t = t.next;
            k--;
        }

        // Until pointer t reaches the last node
        while (t.next != null) {
            y = y.next;
            t = t.next;
        }

        // Swap values at both nodes
        int temp = x.val;
        x.val = y.val;
        y.val = temp;

        return head;
    }
}
