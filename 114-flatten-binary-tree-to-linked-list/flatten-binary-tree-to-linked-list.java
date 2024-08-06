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
    public void flatten(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        flatten(root.left, list);
        flatten(root.right, list);
    }
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        flatten(root, list);
        boolean first = true;
        for (int num: list) {
            if (first) {
                first = false;
                continue;
            }
            root.right = new TreeNode(num);
            root.left = null;
            root = root.right;
        }

    }
}