/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(root, res, temp, targetSum);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> temp,int rem){
        if(root==null) return;
        temp.add(root.val);
        rem -= root.val;
        if(root.left == null && root.right == null){
            if(rem == 0){
                res.add(new ArrayList<>(temp));
            }
        }
        dfs(root.left, res, temp, rem);
        dfs(root.right, res, temp, rem);
        temp.remove(temp.size()-1);
    }
}