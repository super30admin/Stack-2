# Time Complexity : Length of logs since a function can be called multiple times
# Space Complexity : Half of the length of the logs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack and initialize res array to number of logs
# Iterate over the logs and split the string using :
# Set curr to starttime of log and check if function starts and if stack is not empty then add stack[-1] as index of res to curr - prev + existing value
# Set prev to curr
# Append the function name to stack
# If function ends pop function name from stack as index of res to curr + 1 - prev + exisiting value
# Set prev to curr + 1
# Return res


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return None
        stack = []
        res = [0] * n
        prev = 0
        for i in range(len(logs)):
            strs = logs[i].split(":")
            curr = int(strs[2])
            if strs[1] == "start":
                if stack:
                    res[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(strs[0]))
            else:
                res[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        return res
