//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildT(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildT(int[] preorder, int[] inorder, int start, int end) {
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        if(start == end)
            return root;
        int inIndex = findIndex(inorder, root.val, start, end);
        if(-1 != inIndex) {
            root.left = buildT(preorder, inorder, start, inIndex-1);
            root.right = buildT(preorder, inorder, inIndex+1, end);
        }
        return root;
    }
    
    public int findIndex(int[] inorder, int preValue, int start, int end) {
        if(start<=end) {
            for(int i = start; i<=end; i++)
                if(inorder[i] == preValue)
                    return i;
        }
        return -1;
    }
}