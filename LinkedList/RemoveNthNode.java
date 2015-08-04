//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(n > 1) {
            fast = fast.next;
            n--;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        
        if(slow == head) head = slow.next; 
        else prev.next = slow.next;
        return head;
    }
}