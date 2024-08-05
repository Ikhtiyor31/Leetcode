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
    private int answer;
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + root.val;
        answer = Math.max(answer, root.val + left);
        answer = Math.max(answer, root.val + right);
        answer = Math.max(answer, root.val);
        answer = Math.max(answer, sum);

        return Math.max(Math.max(left + root.val, right + root.val), root.val);
    }
    public int maxPathSum(TreeNode root) {
        answer = -1000;
        dfs(root);
        return answer;
    }
}