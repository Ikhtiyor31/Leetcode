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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            while (size-- > 0) {
                root = q.poll();
                if (root.right != null) {
                    q.add(root.right);
                }
                if (root.left != null) {
                    q.add(root.left);
                }
                sum += root.val;
            }

            pq.add(sum);
        }
        Long answer = -1L;
        while (!pq.isEmpty() && k <= pq.size() && k-- > 0)  {
            answer = pq.poll();
        }

        return answer;
    }
}