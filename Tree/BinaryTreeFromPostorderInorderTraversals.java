//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    
    static int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1; 
        return buildT(postorder, inorder, 0, inorder.length-1);
        
    }    
    public TreeNode buildT(int[] postorder, int[] inorder, int start, int end) {
        if(start>end) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        if(start == end)
            return root;
        int inIndex = findIndex(inorder, root.val, start, end);
        if(-1 != inIndex) {
            root.right = buildT(postorder, inorder, inIndex+1, end);
            root.left = buildT(postorder, inorder, start, inIndex-1);
        }
        return root;
    }
    
    public int findIndex(int[] inorder, int postValue, int start, int end) {
        if(start<=end) {
            for(int i = start; i<=end; i++)
                if(inorder[i] == postValue)
                    return i;
        }
        return -1;
    }
    

}