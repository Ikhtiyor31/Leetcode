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
    static class Pair<K, V> {
        K first;
        V second;
        Pair(K f, V s) {
            first = f;
            second = s;
        } 
    }
    int findDepth(TreeNode root, int x) {
        if (root == null) 
            return 0;

        if (root.val == x)
            return 1;

        int left = findDepth(root.left, x);
        int right = findDepth(root.right, x);

        if (left != 0) {
            return left + 1;
        }  

        if (right != 0) {
            return right + 1;
        }


        return 0;     
    }

    public TreeNode findParent(TreeNode root, int x, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return parent;
        }

        TreeNode left = findParent(root.left, x, root);
        TreeNode right = findParent(root.right, x, root);

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
        
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        
        int xDepth = findDepth(root, x);
        int yDepth = findDepth(root, y);
        TreeNode xParent = findParent(root, x, null);
        TreeNode yParent = findParent(root, y, null);


        return xDepth == yDepth && xParent != yParent;
    }
}