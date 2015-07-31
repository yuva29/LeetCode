//https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPath(root, sum);
    }
    
    public boolean hasPath(TreeNode root, int sum) {
        if(root != null) {
            int subSum = sum - root.val;
            if(root.left == null && root.right == null)
                return subSum == 0;
            return (hasPath(root.left, subSum) || hasPath(root.right, subSum));        
        }
        return false;
    }
}