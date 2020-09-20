# APPROACH 1: Stack solution
# Time Complexity : O(n), n: len(logs)
# Space Complexity : O(n), due to space of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Use stack to store the ID of previous processes and maintain a previous timestamp
# 2. If current log status is "start" -> then update the duration of the current process (the current one before this log entry came) (whose ID is stack's top) in result array
#                                      -> then append the current ID to the stack. and set the previous timestamp to current timestamp (since start is at the begining of the timestamp
# 3. If current log status is "end" -> then update the current process's duration in result. and pop from the stack
#                                   -> then set the previous timestamp to current timestamp + 1 (as end is till the end of the timestamp).

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        if logs is None or len(logs) < 1:
            return []
        
        stack, prev_timestamp, result = [], 0, [0 for _ in range(n)]
        
        for log in logs:
            ID, status, timestamp = log.split(':')
            ID, timestamp = int(ID), int(timestamp)
            
            if status == "start":
                if len(stack) > 0:
                    result[stack[-1]] += (timestamp - prev_timestamp)
                stack.append(ID)
                prev_timestamp = timestamp
                
            elif status == "end":
                result[ID] += (timestamp - prev_timestamp + 1)
                stack.pop()
                prev_timestamp = timestamp + 1
                
        return result
