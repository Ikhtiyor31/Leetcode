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

 public class Pair<K, V> {
    K first;
    V second;
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
 }
class Solution {
    Pair<TreeNode, Integer> findParent(TreeNode root, TreeNode parent, int x, int depth) {
        if (root == null) {
            return null;
        }

        if (root.val == x) {
            return new Pair<>(parent, depth);
        }

        Pair<TreeNode, Integer> left = findParent(root.left, root, x, depth + 1);
        Pair<TreeNode, Integer> right = findParent(root.right, root, x, depth + 1);

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Pair<TreeNode, Integer> first = findParent(root, null, x, 0);
        Pair<TreeNode, Integer> second = findParent(root, null, y, 0);
        if (first == null || second == null) {
            return false;
        }

        return first.first != second.first && first.second == second.second;
    }
}