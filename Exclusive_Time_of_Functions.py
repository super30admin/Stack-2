# Time Complexity : O(N), where N is the number of logs
# Space Complexity : O(N)
from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        result = [0] * n
        prev_time = 0

        for log in logs:
            fid, event, time = log.split(":")
            fid, time = int(fid), int(time)

            if event == "start":
                if stack:
                    result[stack[-1]] += time - prev_time
                stack.append(fid)
                prev_time = time
            else:
                result[stack.pop()] += time - prev_time + 1
                prev_time = time + 1

        return result