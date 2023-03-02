"""
Time Complexity : O(n) n = length of logs
Space Complexity : O(n)
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return []
        out = [0 for i in range(n)]
        stack = []
        prev = 0
        curr = 0
        for log in logs:
            x = log.split(":")
            curr = int(x[2])
            if x[1] == "start":
                if stack:
                    out[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(x[0]))
            elif x[1] == "end":
                out[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        return out
