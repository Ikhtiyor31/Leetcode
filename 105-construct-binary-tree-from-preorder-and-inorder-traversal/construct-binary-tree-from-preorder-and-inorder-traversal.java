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
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int midIndex = inorderMap.get(rootVal);
        root.left = buildTreeHelper(preorder, preIndex + 1, left, midIndex  - 1);
        root.right = buildTreeHelper(preorder, preIndex + midIndex - left + 1, midIndex + 1, right);

        return root;
    }
}