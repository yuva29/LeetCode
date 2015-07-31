//https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        result.add(temp);
        
        while(!q1.isEmpty()) {
            TreeNode t = q1.remove();
            if(null != t.left) 
                q2.add(t.left);
            if(null != t.right)
                q2.add(t.right);
            
            if(q1.isEmpty()) {
                temp = new ArrayList<Integer>();
                while(!q2.isEmpty()) {
                    TreeNode tmp = q2.remove();
                    temp.add(tmp.val);
                    q1.add(tmp);
                }
                if(!temp.isEmpty())result.add(temp);
            }
        }
        return result;
    }
}