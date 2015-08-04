//https://leetcode.com/problems/remove-linked-list-elements/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        
        ListNode current = head;
        ListNode prev = null;
        while(current!=null) {
            if(current.val==val) {
                ListNode next = current.next;
                if(current == head)
                    head = next;
                if(null != prev) prev.next = next;
                current = null;
                current = next;
                continue;
                
            }
            prev = current;
            current = current.next;
        }
        
     return head;   
    }
}