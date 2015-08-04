//https://leetcode.com/problems/linked-list-cycle/

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
        if(head == null) return false;
        
        ListNode slow = head;
        ListNode fast = slow.next;

        while(slow != null && fast != null && slow != fast){
            slow = slow.next;
            if(fast.next != null) fast = fast.next.next;
            else fast = null;
        }
        if(slow !=null && slow == fast) return true;
        
        return false;
        
    }
}