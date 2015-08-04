//https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(null == node) return;
        
        ListNode nxt =  node.next;
        node.val = nxt.val;
        node.next= nxt.next;
        nxt = null;
    }
}