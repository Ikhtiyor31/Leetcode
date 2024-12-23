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
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            int position = 0;
            while (size > 0) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
                size--;
            }

            list.add(level);
        }

        
        int answer = 0;
        for (List<Integer> level: list) {
            Map<Integer, Integer> map = new ConcurrentHashMap<>();
            List<Integer> copy = new ArrayList<>(level);;
            Collections.sort(copy);
            //System.out.println(level + " " + copy);
            for (int i = 0; i < level.size(); i++) {
                map.put(level.get(i), i);
            }

            for (int i = 0; i < level.size(); i++) {
                int counter = copy.get(i);
                if (map.get(counter) != i) {
                    int pos = map.get(counter);
                    map.put(level.get(i), pos);
                    level.set(pos, level.get(i));
                    //System.out.println(map);
                    answer++;
                }
                
            }
            

        }

        return answer;

    }
}
// 0 1 2 3
// 7 6 8 5

// 5 6 7 8
// 0 1 2 3