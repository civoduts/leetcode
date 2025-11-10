from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = defaultdict(list)
        state = [0] * numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)

        def dfs(course: int) -> bool:
            if state[course] == 1:
                return False
            if state[course] == 2:
                return True

            state[course] = 1
            for prereq in graph[course]:
                if not dfs(prereq):
                    return False
            state[course] = 2
            return True

        for course in range(numCourses):
            if state[course] == 0 and not dfs(course):
                return False
        return True
