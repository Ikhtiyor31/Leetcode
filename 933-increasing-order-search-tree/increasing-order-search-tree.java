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
    TreeNode answerTreeNode;
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        root.left = null;
        answerTreeNode.right = root;
        answerTreeNode.left = null;
        answerTreeNode = answerTreeNode.right;
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        answerTreeNode = new TreeNode(-1);
        TreeNode ret = answerTreeNode;
        inorder(root);

        return ret.right;
    }
}