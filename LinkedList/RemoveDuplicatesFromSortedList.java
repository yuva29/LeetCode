//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode current = head;
        ListNode nxt = null;

        while(current != null && current.next != null) {
            nxt = current.next;
            if(current.val == nxt.val) {
                current.next = nxt.next;
                continue;
            }
            current = current.next;
        }
        return head;
    }
}