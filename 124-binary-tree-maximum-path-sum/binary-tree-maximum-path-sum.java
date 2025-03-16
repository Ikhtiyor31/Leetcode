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
    int answer;
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = (root.val + left + right);
        answer = Math.max(answer, sum);
        return Math.max(0, root.val + Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        dfs(root);
        return answer;
    }
}