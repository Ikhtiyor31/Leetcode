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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            // if no child 
            if (root.left == null) {
                return root.right;
            }

            // if only left child 
            if (root.right == null) {
                return root.left;
            }

            // if both children there 
            TreeNode minNode = getMinNode(root.right);
            System.out.println(minNode.val);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMinNode(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        return getMinNode(root.left);
    }
}