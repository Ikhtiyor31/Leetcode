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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            while (length > 0) {
                root = queue.poll();
               
                System.out.println(root.val);
                if (leftToRight) {
                     level.add(root.val);
                } else {
                    level.add(0, root.val);
                }

                if (root.left != null) {
                    queue.offer(root.left);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                }

                length--;
            }
            leftToRight = !leftToRight;            
            list.add(new ArrayList<>(level));
        }

        return list;
    }
}