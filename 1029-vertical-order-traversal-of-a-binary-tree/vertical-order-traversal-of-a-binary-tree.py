# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        vertical = {}
    
        def dfs(root: TreeNode, width: int, depth: int) -> None:
            if not root:
                return
            if width not in vertical:
                vertical[width] = [(depth, root.val)]
            else:
                vertical[width].append((depth, root.val))
            dfs(root.left, width - 1, depth + 1)
            dfs(root.right, width + 1, depth + 1)
        dfs(root, 0, 0)
        i = 0
        sorted_dict = {k: vertical[k] for k in sorted(vertical)}
        answer = []
        for _, key in enumerate(sorted_dict):
            sorted_data = sorted(vertical[key], key=lambda x: (x[0], x[1]))
            second_values = [x[1] for x in sorted_data]
            answer.append(second_values)
        return answer