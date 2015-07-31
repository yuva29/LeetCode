//https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode lt, TreeNode rt){
        if(lt == null && rt == null) return true;
        if(rt == null || lt == null) return false;    
    
        if(lt.val == rt.val){
            return (isSym(lt.left, rt.right) && isSym(lt.right, rt.left));
        }
        return false;
    }
}