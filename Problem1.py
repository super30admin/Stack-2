"""
TC: O(N) {We iterate through the list of logs once. Each log entry is pushed and popped from the stack at most once, 
          leading to a linear time complexity.}
SC: O(N) {We use a stack to store function call information, and in the worst case, when all functions are nested, 
          the stack will hold N elements. We also maintain a result list of size N.}

Approach:
We are tasked with calculating the exclusive execution time for each function given start and end logs. 
Each log entry provides the function ID, type ('start' or 'end'), and timestamp.

We use a stack to simulate the function call process:
    - When a new function starts ('start' log), we first update the exclusive time of the currently running function (if any) 
      by adding the difference between the current start time and the previous timestamp. 
      Then we push the new function onto the stack.
    - When a function ends ('end' log), we calculate its total running time as the difference between the current time and 
      the previous timestamp plus one (to account for inclusive end times). We then add this duration to its result index 
      and pop it from the stack. The `prevTime` is updated to one unit after the current end time, indicating the next time unit.

This ensures that nested function calls are correctly accounted for, with inner function times subtracted 
from the parent’s total duration.

Finally, we return the result list containing the exclusive execution times for all functions.

This problem ran successfully on Leetcode.
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0]*n
        stack = []
        
        fId, fType, fTime = logs[0].split(":")
        stack.append((fId, fType, fTime))
        prevTime = fTime

        for i in range(1, len(logs)):
            currId, currType, currTime = logs[i].split(":")

            if currType == 'start':
                if stack:
                    head = stack[-1]
                    res[int(head[0])] += int(currTime) - int(prevTime)

                stack.append((currId, currType, currTime))
                prevTime = currTime
            
            else:

                res[int(currId)] += int(currTime) - int(prevTime) + 1 
                stack.pop()
                prevTime = int(currTime)+1


        return res
