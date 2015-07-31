//https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {;
        if(root == null) return 0;
        return minDep(root);
    }
    public int minDep(TreeNode root) {
        if(root!=null) {
            if(root.left == null && root.right == null)
                return 1;
            return 1+ Math.min(minDep(root.left), minDep(root.right)); 
        }
        return Integer.MAX_VALUE;
                
    }
}