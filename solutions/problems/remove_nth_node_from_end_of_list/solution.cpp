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
    int getLen(ListNode* head) {
        
        if (head == NULL) {
            return 0;
        }
        
        ListNode *ptr = head;
        int ctr = 0;
        
        while(ptr != NULL) {
            ptr = ptr->next;
            ctr++;
        }
        return ctr;
    }
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        int len = getLen(head);
        
        if (n > len) {
            return head;
        }
        
        ListNode *ptr = head;
        ListNode *prev = NULL;
        
        int ctr = 0;
        
        while(ptr != NULL && ctr < len - n) {
            
            prev = ptr;
            ptr = ptr->next;
            
            ctr++;
        }
        
        if (ptr == NULL) {
            return head;
        } 
        
        if (prev == NULL) {
            
            head = ptr->next;
            delete ptr;
            
            return head;
        }
        
        prev->next = ptr->next;
        delete ptr;
        
        return head;
    }
};