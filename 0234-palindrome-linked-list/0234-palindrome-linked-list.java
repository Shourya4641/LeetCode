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
    // make a dummy pointer pointing at the starting of the linked list
    ListNode current;

    public boolean isPalindrome(ListNode head) {
        current = head;
        return solve(head);
    }

    public boolean solve(ListNode head) {
        if (head == null) return true;

        boolean ans = solve(head.next) && head.val == current.val;

        current = current.next;

        return ans;
    }
}