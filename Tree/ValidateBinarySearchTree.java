//https://leetcode.com/problems/validate-binary-search-tree/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean isBST(TreeNode root, int max, int min) {
        if(root == null) return true;
        
        if(root.val > min && root.val < max) {
            return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
        }
        return false;
    }
}