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
class FindElements {
    private Queue<Pair<TreeNode, Integer>> queue;
    private Set<Integer> exist;
    public FindElements(TreeNode root) {
        queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        exist = new HashSet<>();
        exist.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Pair<TreeNode, Integer> pair = queue.poll();
                if (pair.getKey().left != null) {
                    exist.add(2 * pair.getValue() + 1);
                    queue.add(new Pair<>(pair.getKey().left, 2 * pair.getValue() + 1));
                }

                if (pair.getKey().right != null) {
                    exist.add(2 * pair.getValue() + 2);
                    queue.add(new Pair<>(pair.getKey().right, 2 * pair.getValue() + 2));
                }
                size--;
            }
        }
        
    }
    
    public boolean find(int target) {
        
        return exist.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */