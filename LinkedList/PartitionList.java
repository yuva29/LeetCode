//https://leetcode.com/problems/partition-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode lesser = dummy1;
        ListNode greater = dummy2;
        ListNode current = head;
        
        while(current!=null) {
            if(current.val<x) {
                dummy1.next = current;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = current;
                dummy2 = dummy2.next;
            }
            current = current.next;
        }
        dummy1.next = null;
        dummy2.next = null;
        lesser = lesser.next; greater = greater.next;
        if(lesser == null) return greater;
        if(greater == null) return lesser;
        System.out.println(greater.val);
        dummy1.next = greater;
        return lesser;
        
    }
}