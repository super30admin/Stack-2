'''
Time Complexity - O(n)
Space Complexity - O(n)

Works on Leetcode
'''
from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = deque() #create a stack
        prev = 0
        result = [0] * n
        for log in logs: 
            strArr = log.split(sep = ":") #split the log to string array
            taskId = int(strArr[0]) 
            currTime = int(strArr[2])
            #if the 
            if strArr[1] == "start": #if function is start
                if stack: #check top of the stack if stack is not empty
                    result[stack[-1]] += currTime-prev #get task id of the top and add to its exclusive time in result
                prev = currTime #set the current time as prev 
                stack.append(taskId)#push onto the stack
            else:
                #if function is end function
                result[stack.pop()]+=currTime+1-prev #pop from the stack, actual time will 1+currTime as we are end of that unit
                prev = currTime+1 #prev time is set to 1+currTime
        return result
        