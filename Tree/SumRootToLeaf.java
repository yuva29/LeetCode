//https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(null == root) return 0;
        int[] path = new int[1000];
        getAllPaths(root, path, 0, result);
        int sum = 0;
        for(Integer i: result) {
            sum+=i;
        }
        return sum;
    }
    
    public void getAllPaths(TreeNode root, int[] path, int pathLen, ArrayList<Integer> result) {
        if(root == null) return;
        path[pathLen++] = root.val;
        if(root.left == null && root.right == null) 
            getValue(path, result, pathLen);
        else {
            getAllPaths(root.left, path, pathLen, result);
            getAllPaths(root.right, path, pathLen, result);
        }
    }
    public void getValue(int[] path, ArrayList<Integer> result, int len) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<len; i++) {
            s.append(String.valueOf(path[i]));
        }
        if(s.length()>0) result.add(Integer.parseInt(s.toString()));
    }
}