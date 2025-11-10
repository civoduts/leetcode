from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = defaultdict(list)

        for course, prereq in prerequisites:
            graph[prereq].append(course)

        UNVISITED, VISITING, DONE = 0, 1, 2
        state = [UNVISITED] * numCourses

        def dfs(course: int) -> bool:
            if state[course] == VISITING:
                return False
            if state[course] == DONE:
                return True

            state[course] = VISITING
            for prereq in graph[course]:
                if not dfs(prereq):
                    return False
            state[course] = DONE
            return True

        for course in range(numCourses):
            if state[course] == UNVISITED and not dfs(course):
                return False
        return True
