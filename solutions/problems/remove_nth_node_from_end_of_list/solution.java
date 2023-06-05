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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null)
            return null;
            
        int ct = 0;
        ListNode leadingPtr = head;
        while(leadingPtr != null && ct < n) {
            leadingPtr = leadingPtr.next;
            ct++;
        }
        
        if (leadingPtr == null) 
            return head.next;
        
        ListNode laggingPtr = head;
        ListNode prev = null;
        
        while(leadingPtr != null)
        {
            prev = laggingPtr;
            laggingPtr = laggingPtr.next;
            leadingPtr = leadingPtr.next;
        }
        
        if (laggingPtr == null)
            return head.next;
        
        prev.next = laggingPtr.next;
        
        return head;
        
        
    }
}