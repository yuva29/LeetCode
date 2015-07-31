//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(null == root) return result;
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        int leftToRight = 0;
        currentLevel.add(root);
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        result.add(tmp);
        
        while(currentLevel.size()>0) {
            TreeNode temp = currentLevel.remove(0);
            if(leftToRight != 0) {
                if(null != temp.left)
                    nextLevel.add(temp.left);                
                if(null != temp.right)
                    nextLevel.add(temp.right);                    
            } else {
                if(null != temp.right)
                    nextLevel.add(temp.right);
                if(null != temp.left)
                    nextLevel.add(temp.left);
            }
            
            if(currentLevel.size() == 0) {
                tmp = new ArrayList<Integer>();
                int n = nextLevel.size();
                for(int i = 0; i<n; i++) {
                    tmp.add(nextLevel.get(i).val);
                    currentLevel.add(nextLevel.get(n-i-1));
                }
                nextLevel.clear();
                if(tmp.size()>0) result.add(tmp);
                leftToRight = 1-leftToRight;
            }
        }
        return result;
        
    }
}