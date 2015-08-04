//https://leetcode.com/problems/linked-list-cycle-ii/

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
        if(head == null) return null;
        
        ListNode slow = head;
        ListNode fast = slow.next;

        while(slow != null && fast != null && slow != fast){
            slow = slow.next;
            if(fast.next != null) fast = fast.next.next;
            else fast = null;
        }
        
        if(slow !=null && fast != null && slow == fast) {
            slow = null;
            while(fast!=null && slow != fast) {
                if(slow == null) slow = head;
                else slow = slow.next;
                fast = fast.next;
            }
        }
        
        if(slow == fast) return fast;
        
        return null;
        
    }
}