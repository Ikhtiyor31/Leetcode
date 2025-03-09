# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        vertical = defaultdict(list)
        def dfs(root: TreeNode, width: int, depth: int) -> None:
            if not root:
                return
            vertical[width].append((depth, root.val))
            dfs(root.left, width - 1, depth + 1)
            dfs(root.right, width + 1, depth + 1)
        dfs(root, 0, 0)
       
        sorted_dict = {k: vertical[k] for k in sorted(vertical)}
        answer = []
        for key in sorted(vertical.keys()):
            answer.append([val for depth, val in sorted(vertical[key])])
        return answer