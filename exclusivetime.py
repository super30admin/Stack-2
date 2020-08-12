# using stacks
# begin traversing the logs.
# if the function type of the log is start, add the function id to the stack.
# as soon as you encounter another start log, check the existing top in the stack (this new function maybe the child of an existing function (parent) which maybe present in the stack.)
# increment the time of parent to the time of the child function begin minus the prev (where previous is the timestamp of previous operation in order).
# if the function operation is the end, pop the topmost function out of the stack and increment the time of that function by endtimestamp - prev + 1. 
# previous on the end operation will be endtimestamp + 1.
# Time complexity - O(n) runs for every operation and compares it with only the top of the stack (constant time).
# Space complexity - O(n) (actual - O(n) for result array + O(n/2) for stack)
# Did this code run on leetcode? - yes
# Did you encounter any issues while running it? - None

from collections import deque

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # initialize all the timestamp logs to 0.
        res = [0] * n
        stack = deque()
        
        prev = None
        for log in logs:
            function_id, function_op, timestamp = log.split(":")
            function_id = int(function_id)
            timestamp = int(timestamp)
            if function_op == "start":
                if stack:
                    top = stack[-1]
                    res[top] += (timestamp - prev)
                stack.append(function_id)
                prev = timestamp
            else:
                top = stack.pop()
                res[top] += (timestamp - prev + 1)
                prev = timestamp + 1 
        
        return res
                