/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode leadingPtr = head;
        ListNode laggingPtr = head;
        
        boolean cycleFound = false;
        
        while (leadingPtr != null) {
            
                laggingPtr = laggingPtr.next;
                leadingPtr = leadingPtr.next;
            
            if (leadingPtr != null)
                leadingPtr = leadingPtr.next;
            
            if (laggingPtr != null && leadingPtr != null && leadingPtr == laggingPtr)
            {
                cycleFound = true;
                break;
            }
        }
        return cycleFound;
    }
}