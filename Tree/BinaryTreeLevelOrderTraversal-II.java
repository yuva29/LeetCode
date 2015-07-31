//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        
        TreeNode marker = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        q1.add(root);
        
        while(!q1.isEmpty()) {
            TreeNode temp = q1.remove();
            s.push(temp);
            if(null != temp.right) q2.add(temp.right);
            if(null != temp.left) q2.add(temp.left);            
            if(q1.isEmpty()) {
                s.push(marker);
                while(!q2.isEmpty()) 
                    q1.add(q2.remove());
            }
        }
        
        s.pop(); // removes the last marker
        ArrayList<Integer> tmp = new ArrayList<Integer>();;
        while(!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.println(temp.val);
            if(temp == marker) {
                if(tmp.size() >0 )result.add(tmp);
                tmp = new ArrayList<Integer>();
            } else
            tmp.add(temp.val);
        }
        if(tmp.size()>0 )result.add(tmp);
        return result;
    }

}