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
    int t = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode node = removeNthFromEnd(head.next, n);
        t++;
        if (n == 1 || node != null) {
            head.next = node;
        }
        if (t == n) {
            return head.next;
        }
        return head;
    }
}
