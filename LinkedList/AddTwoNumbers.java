//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        int carry = 0;
        while(l1!=null && l2!=null) {
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            l1 = l1.next; l2 = l2.next;
        }
        
        while(l1!=null) {
            int sum = l1.val+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next; l1= l1.next;           
        }
        while(l2!=null) {
            int sum = l2.val+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next; l2 = l2.next;           
        }   
        if(carry!=0)
            dummy.next = new ListNode(carry);
        return result.next;
    }
}