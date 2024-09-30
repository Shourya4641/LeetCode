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
    public ListNode detectCycle(ListNode head) {
        // slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // traverse the linked list untill slow and fast pointers meet at the same node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // if fast pointer is null or pointing to the last node of the linked list
        // then it implies that there is no cycle in the linked list
        if (fast == null || fast.next == null) {
            return null;
        }

        // if there is a cycle then the distance between starting of the node and the starting of the cycle will be
        // equal to the distance travelled by the head and slow pointer untill both the head and slow pointers are the same
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}