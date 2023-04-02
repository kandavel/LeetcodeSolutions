/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* merge(ListNode* list1, ListNode* list2) {
        if (list1 == NULL)
        return list2;

        if (list2 == NULL)
        return list1;

        ListNode* mergedList;

        ListNode* list1Ptr = list1;
        ListNode* list2Ptr = list2;

        ListNode* headMergedList = mergedList = NULL;

        if (list1->val <= list2->val)
        {
            headMergedList = mergedList = list1;
            list1Ptr = list1Ptr->next;
        } else {
            headMergedList = mergedList = list2;
            list2Ptr = list2Ptr->next;
        }

        while(list1Ptr != NULL && list2Ptr != NULL){

            if(list2Ptr->val <= list1Ptr->val)
            {
                mergedList->next = list2Ptr;
                list2Ptr = list2Ptr->next;
            } else {
                mergedList->next = list1Ptr;
                list1Ptr = list1Ptr->next;
            }
            mergedList = mergedList->next;
        }

        if (list1Ptr != NULL)
        mergedList->next = list1Ptr;

        if (list2Ptr != NULL)
        mergedList->next = list2Ptr;

        return headMergedList;
    }

    ListNode* mergeKLists(vector<ListNode*>& lists) {
    
        int K = lists.size();
        
        if (K == 0)
        return NULL;

        if (K == 1)
        return lists[0];
        
        vector<ListNode*> firstHalf;
        vector<ListNode*> secondHalf;

        for(int i = 0; i < K/2; i++)
        firstHalf.push_back(lists[i]);

        for(int i = K/2; i < K; i++)
        secondHalf.push_back(lists[i]);

        ListNode *firstHalfMergedLists = mergeKLists(firstHalf);
        ListNode *secondHalfMergedLists = mergeKLists(secondHalf);

        return merge(firstHalfMergedLists, secondHalfMergedLists);
    }
};