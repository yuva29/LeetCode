//https://leetcode.com/problems/palindrome-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode getMid(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        int i = 1;
        while(fastPtr!= null && fastPtr.next!=null) {
            prev =  slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(null == fastPtr)
            return prev;
        else if(fastPtr.next == null) // old list
            return slowPtr;
        return null;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode mid = getMid(head);
        if(mid.next == null) return true;
        mid.next = reverse(mid.next);
        // compare head and mid.next
        ListNode head2 = mid.next;
        System.out.println(head.val +"," + head2.val);
        while(head!=null && head2!=null && head.val == head2.val) {
            head = head.next;
            head2 = head2.next;
        }
        if(head2 == null) {
            mid.next = reverse(mid.next);        
            return true;
        }
        mid.next = reverse(mid.next);  
        return false;
    }
    
    public ListNode reverse(ListNode head) {
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