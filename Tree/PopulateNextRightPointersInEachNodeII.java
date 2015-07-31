//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public void fillNext(TreeLinkNode nextLinkNode, TreeLinkNode l) {
        while(nextLinkNode!=null) {
            if(null != l.next) break;
            if(nextLinkNode.left!=null)
                l.next = nextLinkNode.left;
            else if(nextLinkNode.right!=null)
                l.next = nextLinkNode.right;
            nextLinkNode = nextLinkNode.next;
        }        
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        q.add(null);
        connectRight(q);
    }
    
    public void connectRight(Queue<TreeLinkNode> q) {
        while(!q.isEmpty()) {
            TreeLinkNode root = q.remove();
            if(null == root) {
                if(!q.isEmpty()) q.add(null);
                continue;
            }
            if(root.left != null) {
                q.add(root.left);
                if(root.right!=null)
                    root.left.next = root.right;
                else if(root.next!=null) {
                    fillNext(root.next, root.left);
                    TreeLinkNode temp = root.next;
                }
            }
                
            if(root.right!=null) {
                q.add(root.right);
                if(root.next!=null) 
                    fillNext(root.next, root.right);
                else
                    root.right.next = null;
            }
        }
    }
}