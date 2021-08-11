"""
Approach : Stack
Do the same operations that you'd do manually on whiteboard.
1) when you come across start time, push to stack
2) when you come across end time, pop the start time and add the cost to resultant list
    a) cost time = end time - start time
    This needs to be consistant, choose either start of a time unit or end of a time unit. Note from the diagram that the start time is at the beginning of 0 and end time is at the ending of 6. This difference has to be processed consistantly
    b) in my implementation, it is chosen to consider the ending of a time unit for both start time and end time
3) note that for each task, the cost = endtime - starttime - cost of previous task


TC: O(n)
SC: O(n)
"""
from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = deque()
        result = [0]*n
        for log in logs:
            id_, type_, time = log.split(':')
            id_, time = int(id_), int(time)
            if type_ == 'start': 
                stack.append((id_, int(time)-1)) # -1 because, consider only the ending of a time unit
            else: 
                cost = int(time) - stack.pop()[1] # cost of current task
                result[id_] += cost
                if stack: # for the next task, subtract the cost of current task now itself
                    result[stack[-1][0]] -=  cost
        return result