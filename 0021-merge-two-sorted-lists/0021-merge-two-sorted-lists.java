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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
            1. create a new linked list from the above 2 lists
            2. insert the value according to which one of them is the greater one
            3. keep a pointer at the starting of the resultant linked list to return the output
        */

        ListNode resultHead = new ListNode();
        ListNode currentPointer = resultHead;

        // traverse the given lists until one of them is not empty
        while (list1 != null && list2 != null) {

            // check for the given condition
            if (list1.val < list2.val) {
                currentPointer.next = list1;
                list1 = list1.next;
            } else {
                currentPointer.next = list2;
                list2 = list2.next;
            }

            // change the current pointer
            currentPointer = currentPointer.next;
        }

        // when either of the lists is finished with traversing
        currentPointer.next = (list1 == null) ? list2 : list1;

        return resultHead.next;
    }
}