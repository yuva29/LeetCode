//https://leetcode.com/problems/path-sum-ii/
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        int[] path = new int[1000];
        hasPath(root, sum, result, path, 0);
        return result;
    }

    public void hasPath(TreeNode root, int sum, List<List<Integer>> result, int[] path, int pathLen) {
        if(root != null) {
            int subSum = sum - root.val;
            path[pathLen++] = root.val;
            if(root.left == null && root.right == null && subSum == 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int i = 0; i<pathLen; i++)
                    temp.add(path[i]);
                if(temp.size()>0) result.add(temp);
            }
            hasPath(root.left, subSum, result, path, pathLen);
            hasPath(root.right, subSum, result, path, pathLen);
        }
    }
}
