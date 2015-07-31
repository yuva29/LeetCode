// Question  : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode marker = new TreeLinkNode(Integer.MAX_VALUE);
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        q.add(marker);
        
        while(!q.isEmpty()) {
            TreeLinkNode temp = q.remove();
            if(marker == temp) {
                if(!q.isEmpty()) q.add(marker);
                continue;
            }
            if(temp.left!=null) 
                q.add(temp.left);
            if(temp.right != null) 
                q.add(temp.right);
                
            if(q.peek() == marker) 
                temp.next = null;
            else 
                temp.next = q.peek();
        }
    }
}