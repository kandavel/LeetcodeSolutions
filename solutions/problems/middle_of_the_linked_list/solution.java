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
    public ListNode middleNode(ListNode head) {

        if (head == null)
        return null;

        if (head.next == null)
        return head;

        if (head.next.next == null)
        return head.next;

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        ListNode midPtr = head;

        fastPtr = fastPtr.next.next;

        while(fastPtr != null)
        {
            if (fastPtr.next == null)
            {
                midPtr = slowPtr.next;
                break;
            }

            else if (fastPtr.next.next == null)
            {
                midPtr = slowPtr.next.next;
                break;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;  
        }
        return midPtr;
    }
}