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
    public ListNode reverseList(ListNode head) {
        // 3 pointers to reverse the linked list
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        // loop through the linked list untill the end
        while (current != null) {
            // point the next pointer to the next node of current node
            next = current.next;

            // point the current node to the empty node
            current.next = previous;

            // point the previous pointer to the current pointer
            previous = current;

            // point the move the current pointer to the next pointer and keep the process untill end
            current = next;
        }

        return previous;
    }
}