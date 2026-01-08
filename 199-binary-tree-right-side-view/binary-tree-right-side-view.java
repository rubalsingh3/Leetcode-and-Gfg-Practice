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
    public void rightview(TreeNode curr, List<Integer> result, int lvl){
        if(curr == null) return;
        if(lvl == result.size()){
            result.add(curr.val);
        }
        rightview(curr.right, result,lvl+1);
        rightview(curr.left,result,lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =  new ArrayList<Integer>();
        rightview(root,result,0);
        return result;
    }
}