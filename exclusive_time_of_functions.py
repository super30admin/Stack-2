"""
Time Complexity : O(n) where n is the length of the logs
Space Complexity : O(n/2) 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Approch:
1. Initially curr = prev = 0. These variables will help to calulate the current time taken by the process
2. For the start log, push the processID to the stack. 
   Update prev = timeStamp
   Update the result[stack[-1]]  = curr - prev. This indicates the time taken by the current process before halt
3. If the log is end log, then result[stack[-1]]  += (curr + 1) - prev. curr + 1 as the process ends at the end of 3 (in the above example) but our curr is at the start of the 3.
  Update prev = curr + 1
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if len(logs) == 0:
            return []
        result = [0 for _ in range(n)]
        stack = []
        curr = prev = 0

        for i in range(len(logs)):
            currRecord = logs[i].split(":")
            processID = int(currRecord[0])
            curr = int(currRecord[2])
            # print(f"stack, {stack}")
            # print(f"result, {result}")
            if currRecord[1] == "start":
                if len(stack) > 0:
                    result[stack[-1]] += curr - prev
                stack.append(processID)
                prev = curr
            else:
                if len(stack) > 0:
                    result[stack.pop()] += (curr + 1) - prev
                    prev = curr + 1
        return result
