//https://leetcode.com/problems/count-complete-tree-nodes/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int leftHeight(TreeNode root) {
        if(root == null) return 0;
        if(null != root.left)
            return 1 + leftHeight(root.left);
        return 0;
    }
    
    public int rightHeight(TreeNode root) {
        if(root == null) return 0;
        if(null != root.right)
            return 1+rightHeight(root.right);
        return 0;
    }    
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftH = leftHeight(root);
        int rightH = rightHeight(root);
        if(leftH == rightH) 
            return (2<<leftH)-1;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }
}
