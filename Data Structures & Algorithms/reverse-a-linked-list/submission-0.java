// Jai Ganesh
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
    public ListNode reverseList(ListNode head) {
        ListNode current, prev, next;
        
        // if list has only one element no need to reverse
        if(head == null || head.next == null) {
            return head;
        }

        current = head;
        prev = head;

        next = head.next;
        while(next != null) {
            prev = current;
            current = next;
            next = next.next;
            current.next = prev;
        }
        head.next = null;
        return current;
    }
}
