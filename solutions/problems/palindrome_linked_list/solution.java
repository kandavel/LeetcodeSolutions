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
    public ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(temp!=null) {
            next = temp.next;
            temp.next = prev;
            
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    public boolean isEqual(ListNode a, ListNode b, int l) {
        ListNode temp1 = a, temp2= b;
        int ct = 0;
        
        while(temp1 != null && temp2 != null && ct < l) {
            if (temp1.val != temp2.val)
                return false;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
            
            ct++;
        }
        return (ct == l);
    }
    
    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
            
            if (fast != null)
                fast = fast.next;
        }
        return slow;
    }
    
    public int len(ListNode head) {
        int ct = 0;
        ListNode ptr = head;
        
        while(ptr != null) {
            ptr = ptr.next;
            ct++;
        }
        return ct;
    }
    
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = getMid(head);
        int lenHalf = len(mid);
        
        return isEqual(head, reverseLL(mid), lenHalf);
    }
}