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
    public boolean isPalindrome(ListNode head) {
        // create a stack 
        Stack<Integer> stack = new Stack();

        // create a dummy pointer pointing at the head of the linked list
        ListNode current = head;

        // push all the elements into the stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;

        // pop all the elements from the stack and traverse the linked list at the same time
        while ((current != null) && (current.val == stack.pop())) {
            current = current.next;
        }

        return current == null;
    }
}