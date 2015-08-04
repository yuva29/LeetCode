//https://leetcode.com/problems/reverse-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(null == head) return head;
        
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        
        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}