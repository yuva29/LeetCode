//https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    static int maxSum = Integer.MIN_VALUE;    
    public int maxPathSum(TreeNode root) {
        if(null == root) return 0;
        maxSum = Integer.MIN_VALUE; 
        calcMaxSum(root);
        return maxSum;
    }
    
    public int calcMaxSum(TreeNode root) {
        if(null == root) return 0;
        int left = calcMaxSum(root.left);
        int right = calcMaxSum(root.right);
        int temp = Math.max(root.val, Math.max(right+root.val, left+root.val));
        maxSum = Math.max(temp, Math.max(maxSum, left+right+root.val));
        return temp;
    }
} 