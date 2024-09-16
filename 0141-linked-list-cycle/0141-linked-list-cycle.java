/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
            1. 2 pointer approach
            2. fast and slow are the 2 pointers 
            3. increase the fast pointer with 2 times the speed of slow pointer
            4. incase there is a cycle present, the slow and fast pointer will be same for atleast once during the loop
            5. in case they are not same ever then return false
        */

        ListNode fast = head;
        ListNode slow = head;

        // traverse the linked list
        while (fast != null && fast.next != null) {
            // increment of the pointer
            fast = fast.next.next;
            slow = slow.next;

            // if fast and slow pointer are the same or pointing to the same node
            if (fast == slow) {
                return true;
            }
        }
        // no cycle is present
        return false;

    }
}