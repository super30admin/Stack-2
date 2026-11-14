# Time Complexity : Length of logs since a function can be called multiple times
# Space Complexity : Half of the length of the logs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack and initialize res array to number of logs
# Iterate over the logs and split the string using : to get id, event, timestamp
# Set curr to timestamp of log and check if function starts and if stack is not empty then add stack[-1] as index of res to curr - prev + existing value
# Set prev to curr
# Append the id to stack
# If function ends pop taskid from stack as index of res to curr + 1 - prev + exisiting value
# Set prev to curr + 1
# Return res

class Solution:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        res = [0] * n
        stack = []
        prev = 0
        curr = 0
        for i in range(len(logs)):
            id, event, timestamp = logs[i].split(":")
            taskid = int(id)
            curr = int(timestamp)
            if event == "end":
                res[stack.pop()] += curr + 1 - prev
                prev = curr + 1
            else:
                if stack:
                    res[stack[-1]] += curr - prev
                prev = curr
                stack.append(taskid)
        return res
'''Time - Length of logs since a function can be called multiple times
Space - Half of the length of the logs'''