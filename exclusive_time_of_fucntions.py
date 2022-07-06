# Time Complexity : O(N) where N is number of the logs
# Space Complexity : O(N) where N is number of the logs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        timings = [0 for i in range(n)]
        stack = []
        
        for log in logs:
            pid, op, time = log.split(":")
            if op == "start":
                if len(stack) != 0:
                    timings[stack[-1]] += int(time) - int(prev)

                prev = int(time)
                    
                stack.append(int(pid))
                
            elif op == "end":
                timings[stack[-1]] += int(time) - int(prev) + 1
                stack.pop()
                prev = int(time) + 1
        return timings