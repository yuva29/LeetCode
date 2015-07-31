//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length-1);
    }
    
    public TreeNode constructBST(int[] nums, int left, int right) {
        if(left<=right) {
            int mid = left + (right-left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = constructBST(nums, left, mid-1);
            root.right = constructBST(nums, mid+1, right);
            return root;
        }
        return null;
    }
}