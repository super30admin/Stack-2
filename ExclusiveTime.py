#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        curr = 0
        prev = 0
        result = [0] * n
        for i in range(len(logs)):
            abc = logs[i].split(":")
            curr = int(abc[2])
            if abc[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(int(abc[0]))
                prev = curr
            else:
                result[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        
        return result

# Approach:
# 1. Initialize a stack to keep track of the current function being executed.
# 2. Initialize a variable `curr` to keep track of the current time.
# 3. Initialize a variable `prev` to keep track of the previous time.
# 4. Initialize a list `result` to store the exclusive time for each function.
#     5. Iterate through the logs. For each log, split it into three parts: function ID,
# operation (start or end), and time.
# 6. If the operation is "start", push the function ID onto the stack and update the `
# previous time to the current time.
# 7. If the operation is "end", pop the function ID from the stack, update the exclusive
# time for the function by adding the difference between the current time and the previous
#     time, and update the previous time to the current time.
# 8. Return the list of exclusive times for each function.
    