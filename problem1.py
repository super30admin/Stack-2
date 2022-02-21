# Time Complexity : O(m) m is the number of logs
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs is None or len(logs) == 0:
            return []

        stack = []
        prev = 0

        result = [0] * (n)

        for log in logs:

            fId, action, time = log.split(":")

            if action == "start":
                if stack:
                    result[stack[-1]] += int(time) - prev
                prev = int(time)
                stack.append(int(fId))
            else:
                result[stack[-1]] += int(time) - prev + 1
                prev = int(time) + 1
                stack.pop()

        return result
