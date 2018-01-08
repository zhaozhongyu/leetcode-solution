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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == nullptr || head->next == nullptr){
            return head;
        }
        ListNode* tmp = head;
        ListNode* nodes[k];
        for(int i = 0; i < k; i++){
            if(tmp == nullptr){
                return head;
            }
            nodes[i] = tmp;
            tmp = tmp->next;
        }
        tmp = nodes[k-1];
        ListNode* last = nodes[k-1]->next;
        for(int i = k-1;i>0; i--){
            nodes[i]->next = nodes[i-1];
        }
        head->next = last;
        if (head->next != nullptr){
            head->next = reverseKGroup(head->next, k);
        }
        return tmp;
    }
};