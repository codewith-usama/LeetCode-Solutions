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
class Solution
{
public:
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        priority_queue<pair<int, ListNode *>, vector<pair<int, ListNode *>>, greater<pair<int, ListNode *>>> pq;

        // Add the heads of all linked lists to the priority queue
        for (ListNode *head : lists)
        {
            if (head)
            {
                pq.push(make_pair(head->val, head));
            }
        }

        ListNode *dummy = new ListNode(0);
        ListNode *tail = dummy;

        while (!pq.empty())
        {
            pair<int, ListNode *> p = pq.top();
            pq.pop();

            tail->next = p.second;
            tail = tail->next;

            // Add the next element of the popped list to the priority queue
            if (p.second->next)
            {
                pq.push(make_pair(p.second->next->val, p.second->next));
            }
        }

        return dummy->next;
    }
};
