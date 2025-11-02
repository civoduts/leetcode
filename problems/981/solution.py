from collections import defaultdict


class TimeMap:

    def __init__(self):
        self._store = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self._store[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        values = self._store[key]
        l, r = 0, len(values) - 1
        ret = ""

        while l <= r:
            mid = l + (r - l) // 2
            v, t = values[mid]

            if t <= timestamp:
                ret = v
                l = mid + 1
            else:
                r = mid - 1
        return ret
