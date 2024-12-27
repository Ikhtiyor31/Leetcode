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

    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        TreeNode answerTree = new TreeNode(-1);
        TreeNode ret = answerTree;
        for (int num: list) {
            TreeNode newTree = new TreeNode(num);
            answerTree.right = newTree;
            answerTree.left = null;
            answerTree = answerTree.right;
        }

        return ret.right;
    }
}