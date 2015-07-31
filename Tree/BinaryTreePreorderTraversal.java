//https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        preorder(root, result);
        return result;
    }
    
    public void preorder(TreeNode root, ArrayList<Integer> result) {
        if(null != root) {
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }        
    }
    
}