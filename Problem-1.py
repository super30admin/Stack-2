# Time Complexity :O(N) where N is no of logs
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# We use a stack to keep track of currently executing functions along with their start times.
# When a new function starts, we pause the previous one and accumulate its execution time.
# When a function ends, we finalize its time and resume the parent function accordingly.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0]*n
        stack = []
        for i in range(len(logs)):
            log = logs[i].split(":")
            log[2] = int(log[2])
            log[0] = int(log[0])
            if log[1] =="start":
                if stack:
                    result[stack[-1][0]] += log[2] - stack[-1][1]
                stack.append([log[0],log[2]])
            else:
                popped_ele = stack.pop()
                result[popped_ele[0]] += log[2]-popped_ele[1]+1
                if stack:
                    stack[-1][1] = log[2]+1
        return result
