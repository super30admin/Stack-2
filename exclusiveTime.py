# Approach: Stack
# Time Complexity :O(n)
# Space Complexity :O(1)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev = 0
        for log in logs:
            splits = log.split(":")
            curr = int(splits[2])
            if "start" in log:
                # if current `log` is a start log, update the result for
                # pid at the top of stack if stack is non-empty, using curr-prev
                # then set prev to curr
                if stack:
                    result[stack[-1]] += curr-prev
                    prev = curr
                # push curr pid to stack
                stack.append(int(splits[0]))
            else: # "end" in log
                # if log is an "end" log pop the stack and update result as curr-prev+1
                # +1 is needed to account for the fact that we are trying to get the duration
                # not the difference. Similar to counting diff between two dates.
                result[stack.pop()] += curr-prev+1
                # +1 is also needed here to ensure we are not counting end of the last pid.
                # e.g. if pid 1 is ending at time 5, then pid 0 can't be using time 5 in its calculation
                # so set new value of `prev` as curr+1 => 5+1 => 6, see example on 
                # https://leetcode.com/problems/exclusive-time-of-functions/
                prev = curr+1
        return result