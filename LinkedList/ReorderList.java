//https://leetcode.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(null == head) return;
        
        ListNode current = head;
        HashMap<Integer, ListNode> listMap = new HashMap<Integer, ListNode>();
        int count = 0;
        while(current!=null) {
            listMap.put(++count, current);
            current = current.next;
        }
        int len = listMap.keySet().size(); 
        if(len<3) return; 
        
        current = head;
        int iter = 1;
        while(iter<=len/2) {
            ListNode prev = listMap.get(count-1);
            if(null!= prev) prev.next = null;
            ListNode temp = listMap.get(count);
            ListNode nxt = current.next;
            current.next = temp;
            temp.next = nxt;
            current = nxt;
            count--;
            iter++;
        }
    }
    
    public void printList(ListNode head) {
        ListNode current = head;
        while(null != current) {
            System.out.print(current.val +"->");
            current = current.next;
        }
        System.out.println();
    }
}