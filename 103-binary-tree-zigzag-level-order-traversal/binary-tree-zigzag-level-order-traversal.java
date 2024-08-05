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
        int traverseCount = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (length > 0) {
                root = queue.poll();
                temp.add(root.val);
                System.out.println(root.val);
                if (root.right != null) {
                    queue.offer(root.right);
                }

                if (root.left != null) {
                    queue.offer(root.left);
                }

                length--;
            }
            if (traverseCount % 2 == 0) {
                Collections.reverse(temp);
            }
            list.add(new ArrayList<>(temp));
            traverseCount++;
        }

        return list;
    }
}