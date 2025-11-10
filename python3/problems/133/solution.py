from typing import Optional


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:  # type: ignore
        cloned = {}

        def dfs(node: Optional["Node"]) -> Optional["Node"]:
            if node.val in cloned:
                return cloned[node.val]

            clone = Node(node.val)
            cloned[node.val] = clone

            for nei in node.neighbors:
                clone.neighbors.append(dfs(nei))
            return clone

        return dfs(node) if node else None
