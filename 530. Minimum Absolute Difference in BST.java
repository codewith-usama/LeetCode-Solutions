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
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nums = new LinkedList<Integer>();
        inorder(root, nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - 1; i ++) {
            int cand = Math.abs(nums.get(i + 1) - nums.get(i));
            min = Math.min(min, cand);
        }
        return min;
    }
    private void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}