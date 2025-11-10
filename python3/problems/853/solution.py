class Solution:
    def carFleet(self, target: int, position: list[int], speed: list[int]) -> int:
        cars = sorted(zip(position, speed), reverse=True)

        fleets = 0
        max_time = 0.0
        for pos, v in cars:
            time = (target - pos) / v
            if time > max_time:
                fleets += 1
                max_time = time
        return fleets
