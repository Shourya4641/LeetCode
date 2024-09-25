/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // edge case
        if (headA == null || headB == null) {
            return null;
        }

        // current pointers of the given 2 lists
        ListNode currentA = headA;
        ListNode currentB = headB;

        // loop untill both the current pointers point to the same node
        // length of the 2 linked list doesn't matter here
        while (currentA != currentB) {
            // check if the current pointer is pointing to the end of one of the linked lists
            // if true, point the current pointer to the head of another linked list
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }

        return currentA;        
    }
}