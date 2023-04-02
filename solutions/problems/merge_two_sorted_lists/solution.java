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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
        return list2;

        if (list2 == null)
        return list1;

        ListNode mergedList;

        ListNode list1Ptr = list1;
        ListNode list2Ptr = list2;

        ListNode headMergedList = mergedList = null;

        if (list1.val <= list2.val)
        {
            headMergedList = mergedList = list1;
            list1Ptr = list1Ptr.next;
        } else {
            headMergedList = mergedList = list2;
            list2Ptr = list2Ptr.next;
        }

        while(list1Ptr != null && list2Ptr != null){

            if(list2Ptr.val <= list1Ptr.val)
            {
                mergedList.next = list2Ptr;
                list2Ptr = list2Ptr.next;
            } else {
                mergedList.next = list1Ptr;
                list1Ptr = list1Ptr.next;
            }
            mergedList = mergedList.next;
        }

        if (list1Ptr != null)
        mergedList.next = list1Ptr;

        if (list2Ptr != null)
        mergedList.next = list2Ptr;

        return headMergedList;
    }
}