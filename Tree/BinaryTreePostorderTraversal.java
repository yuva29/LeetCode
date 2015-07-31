//https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            
            if(null != temp.left) s1.push(temp.left);
            if(null != temp.right) s1.push(temp.right);
            s2.push(temp);
        }
        
        while(!s2.isEmpty()){
            result.add(s2.pop().val);
        }
        return result;
    }
}