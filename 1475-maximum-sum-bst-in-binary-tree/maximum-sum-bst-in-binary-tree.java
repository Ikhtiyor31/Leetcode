/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int maxSum = 0;

    public int[] isValidBST(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

       
        int[] left = isValidBST(root.left);
        int[] right = isValidBST(root.right);

        
        if (left[0] == 0 || right[0] == 0 || root.val <= left[3] || root.val >= right[2]) {
            return new int[]{0, 0, 0, 0};
        }

        
        int sum = root.val + left[1] + right[1];
        maxSum = Math.max(maxSum, sum);

        // Return updated tuple (valid, sum, min, max)
        int minVal = Math.min(root.val, left[2]);
        int maxVal = Math.max(root.val, right[3]);
        int res = left[0] == 1 && right[0] == 1 ? 1: 0;
        return new int[]{res, sum, minVal, maxVal};
    }

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        isValidBST(root);
        return maxSum;
    }
}