from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = {i: [] for i in range(numCourses)}
        for course, prereq in prerequisites:
            graph[course].append(prereq)

        visited = set()
        def dfs(course: int) -> bool:
            if course in visited:
                return False
            if not graph[course]:
                return True
            visited.add(course)
            for p in graph[course]:
                if not dfs(p):
                    return False
            visited.remove(course)
            graph[course] = []

            return True

        for course in range(numCourses):
            if not dfs(course):
                return False
        return True
