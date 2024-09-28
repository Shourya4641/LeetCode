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
    public ListNode sortList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // pointer nodes
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // go to the middle of the linked list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // split the list
        prev.next = null;

        // recursively slpit the list
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        // merge the two sorted list
        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        // starting node for the sorted list
        ListNode tempHead = new ListNode(0);

        // pointer to the tempNode
        ListNode headPointer = tempHead;

        // traverse the 2 input lists
        while (list1 != null && list2 != null) {
            // sort and merge the list
            if (list1.val < list2.val) {
                headPointer.next = list1;
                list1 = list1.next;
            } else {
                headPointer.next = list2;
                list2 = list2.next;
            }
            // move the headPointer
            headPointer = headPointer.next;
        }

        // after one of the input lists is completed with the traversing
        if (list1 == null) {
            headPointer.next = list2;
        }

        if (list2 == null) {
            headPointer.next = list1;
        }

        return tempHead.next;
    }
}