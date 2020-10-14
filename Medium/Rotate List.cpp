//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/
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
    int getLength(ListNode*head) {
        int cnt = 0;
        while(head != NULL) {
            cnt++;
            head = head->next;
        }
        return cnt;
    }
    ListNode* rotateRight(ListNode* head, int k) {
        
        if(head == NULL ||head->next == NULL)
            return head;
        int length = getLength(head);
        k %= length;
        while(k--) {
            ListNode * current = head;
            ListNode *prev = NULL;
            while(current->next != NULL) {
                prev = current;
                current = current->next;
            }
            prev->next = NULL;
            current->next = head;
            head = current;
            
        }
        return head;
    }
};
