//https://leetcode.com/problems/copy-list-with-random-pointer/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        RandomListNode newList = null;
        RandomListNode current = head;
        RandomListNode nxt = null;
        RandomListNode tempList = null;
        
        HashMap<RandomListNode, RandomListNode> hm =  new HashMap<RandomListNode, RandomListNode>();
        
        while(current != null){
            RandomListNode temp = new RandomListNode(current.label);
            temp.random = current;
            nxt = current.next;
            current.next = temp;     
            hm.put(current,nxt);
            
            if(newList == null) {
                newList = temp;
                tempList = temp;
            }
            else {
                tempList.next = temp;
                tempList = tempList.next;
            }
            current = nxt;
        }
        
        tempList = newList;
        
        while(tempList!=null) {
            if(tempList.random.random != null) tempList.random = tempList.random.random.next;
            else tempList.random = null;
            tempList = tempList.next;
        }
        
        tempList = head;
        tempList.next = hm.get(tempList);
        
        while(tempList.next != null) {
            tempList = tempList.next;
            tempList.next = hm.get(tempList);
        }
        return newList;
    }
}
