# Problem 1 : Exclusive Time of Functions
# Time Complexity : O(L) where L is the number of log lines in logs
# Space Complexity : O(n) where n is the number of the tasks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # define and initialize the result with size as n
        result = [0] * n
        # define stack
        stack = []
        # define current and prev time variable
        current = 0
        prev = 0

        # loop through logs list
        for log in logs:
            # get taskidstr, type and timestr from the log line
            taskIdStr, typeS, timeStr = log.split(":")
            # get the task id as int
            taskId = int(taskIdStr)
            # get the time stamp as int and store in the current
            current = int(timeStr)
            # check the type of the log line
            if typeS == "start":
                # if the type is start
                # check if the stack is not empty
                if stack:
                    # if the stack is not empty then calculate the the value for the task id which is at top of the stack
                    # it is sum of the value at task id position in the result, (current - prev)
                    result[stack[-1]] += current - prev
                # push the task id in the stack
                stack.append(taskId)
                # set the prev to current
                prev = current
            # if the type of the log line is end
            else:
                # pop the task id from the stack
                popTask = stack.pop()
                # calculate the value as sum of the value at task id position in the result, (current + 1 - prev)
                result[popTask] += current + 1 - prev
                # set the previous as current + 1
                prev = current + 1
        # return result
        return result
