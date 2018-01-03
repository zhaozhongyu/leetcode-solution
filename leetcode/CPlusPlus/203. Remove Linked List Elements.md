/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* curr = head;
        ListNode* left;
        while(curr != nullptr){
            if(curr->val == val){
                if(curr == head){
                    head = curr->next;
                    left = head;
                } else {
                    left->next = curr->next;
                }
            } else {
                left = curr;
            }
            curr = curr->next;
        }
        return head;
    }
};