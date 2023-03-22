public /**
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode data = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            data.next = new ListNode(sum % 10);
            data = data.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        
        if (carry > 0)
            data.next = new ListNode(carry);
        
        return dummy.next;
    }} 2. Add Two Numbers {
    
}
