# Time Complexity : O(N) as we are iterating through the logs list once
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a stack to keep track of the function IDs.
# I will iterate through each log entry.
# If the log entry is a "start" event, I will push the function ID onto the stack.
# If the log entry is an "end" event, I will pop the function ID from the stack and calculate the exclusive time.
# I will also update the previous timestamp to ensure accurate time calculation for nested functions.
# Finally, I will return the result list containing the exclusive times for each function.

from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev = 0
        for i in logs:
            part = i.split(":")
            prId = int(part[0])
            prStatus = part[1]
            prTime = int(part[2])
            if prStatus == "start":
                if stack:
                    result[stack[-1]] +=  prTime - prev
                stack.append(prId)
            else:
                prTime += 1
                result[stack.pop()] += prTime - prev
            prev = prTime
        return result

        