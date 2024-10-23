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

    public boolean isSameParent(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null) {
            if ((root.left.val == x || root.left.val == y) && (root.right.val == x || root.right.val == y)) {
                return true;
            }
        }

        boolean left = isSameParent(root.left, x, y);
        boolean right = isSameParent(root.right, x, y);

        return left || right;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        
        int xDepth = findDepth(root, x);
        int yDepth = findDepth(root, y);
        if (xDepth != yDepth) {
            return false;
        }

        return !isSameParent(root, x, y);
    }
}