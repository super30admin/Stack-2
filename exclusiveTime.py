"""
when end -- curr + 1 - prev (1 is added here since when a new timestamp starts, 
the previous ends at 1 step forward)
when start --  curr - prev
TC - O(n)
SC - O(1)
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        rtnData = [0] * n
        stack = []
        prev = 0
        for log in logs:
            splits = log.split(":")
            curr = int(splits[2])
            if "start" in log:
                if stack:
                    rtnData[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(splits[0]))
            else:
                rtnData[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return rtnData
