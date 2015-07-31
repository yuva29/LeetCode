//https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList();
       if(root == null) return result;
       
       TreeNode marker = new TreeNode(Integer.MAX_VALUE);
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);
       q.add(marker);
       TreeNode prev = root;
       //result.add(root.val);
       while(!q.isEmpty()) {
           TreeNode temp = q.remove();
           if(null != temp.left) q.add(temp.left);
           if(null != temp.right) q.add(temp.right);           
           if(temp == marker) {
               result.add(prev.val);
               if(!q.isEmpty()) q.add(marker);
           }
           else prev = temp;
       }
       return result;
    }
}