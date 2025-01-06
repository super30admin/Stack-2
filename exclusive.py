# The exclusiveTime method calculates the exclusive execution time for each function in a log sequence.

# Use a stack to track active functions:
# - On "start": 
#   - Add the elapsed time to the current function's total if the stack is not empty.
#   - Push the new function onto the stack and update `prev_time`.
# - On "end": 
#   - Pop the function from the stack and calculate its exclusive time (include the current timestamp).
#   - Update `prev_time` for the next event.

# Return the accumulated times for all functions.

# TC: O(n) - Single pass through the logs.
# SC: O(n) - Space for the stack.


from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        stack = []
        prev_time = 0
        ans = [0 for i in range(n)]
        
        for i in range(0,len(logs)):
            fid, state, time = logs[i].split(':')
            fid, time = int(fid), int(time)
            
            if state == "start":
                if stack:
                    ans[stack[-1]] += time - prev_time
                
                stack.append(fid)
                prev_time = time
           
            else:
                ans[stack.pop()] += time - prev_time + 1
                prev_time = time + 1
            
        return ans