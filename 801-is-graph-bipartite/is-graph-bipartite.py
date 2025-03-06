class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        if len(graph) == 0:
            return True
        blue = 1
        red = 2
        queue = []
        visited = {}
        for i in range(len(graph)):
            if i in visited:
                continue
            queue.append([i, blue])
            visited = {i: blue}
            while queue:
                n = len(queue)
                while n > 0:
                    node, color = queue.pop(0)
                    for adjacent in graph[node]:
                        if adjacent in visited:
                            if visited[adjacent] == color:
                                return False
                            else:
                                continue
                        if color == blue:
                            queue.append([adjacent, red])
                            visited[adjacent] = red
                        else:
                            queue.append([adjacent, blue])
                            visited[adjacent] = blue
                        
                    n -= 1
        return True