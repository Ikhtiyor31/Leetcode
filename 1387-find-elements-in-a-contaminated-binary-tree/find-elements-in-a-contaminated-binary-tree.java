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
    private Set<Integer> exist;
    public FindElements(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        exist = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode pair = queue.remove();
            exist.add(pair.val);
            if (pair.left != null) {
                pair.left.val = 2 * pair.val + 1;
                queue.add(pair.left);
            }

            if (pair.right != null) {
                pair.right.val = 2 * pair.val + 2;
                queue.add(pair.right);
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