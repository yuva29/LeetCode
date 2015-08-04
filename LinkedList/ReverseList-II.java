//https://leetcode.com/problems/reverse-linked-list-ii/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        
        ListNode current = head;
        int tempM = m;
        ListNode prev = null;
        while(current!=null && tempM-1>0) {
            prev = current;
            current = current.next;
            tempM--;
        }
        ListNode reversed = reverseList(current, n-m+1);
        if(m == 1) head = reversed;
        else if(null != prev) prev.next = reversed;
        return head;
    }
    
    public ListNode reverseList(ListNode head, int n) {
        if(null == head) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        while(current!=null && n>0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            n--;
        }
        head.next = current;
        return prev;
    }
}