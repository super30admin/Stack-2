'''
Solution:
1.  At one particular instance, only one function will be running which is the latest one.
    This follows LIFO principle and so stack would be a better approach for proceeding.
2.  Whenever the log consists of 'start', push it onto the stack adding the previous timestamps
    of functions that were present on the stack earlier.
3.  Whenever the log consists of 'end', pop the top element from the stack and add the corresponding
    time to the respective function id.

Time Complexity:    O(L)    |   Space Complexity:   O(F)
L - # of logs and F - # of function calls

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        #   initialize final resultant array, stack, prior and current time
        finalResult = [0 for i in range(n)]
        stack = []
        priorTime = 0
        currentTime = 0
        
        #   for each log
        for log in logs:
            
            #   split the log into function id, event and timestamp
            logSplit = log.split(':')
            
            functionId = int(logSplit[0])
            event = logSplit[1]
            timeStamp = int(logSplit[2])
            
            #   current timestamp would be the extracted one
            currentTime = timeStamp
            
            #   if event is 'start' => add [cuurent time - prior time] to the function id 
            #   present at the top of stack
            #   later, push current log's function id
            if (event == 'start'):
                if (len(stack) > 0):
                    finalResult[stack[-1]] += (currentTime - priorTime)
                stack.append(functionId)
                priorTime = currentTime
             
            #   else => add [current time - prior time] to the current function id
            #   later, pop the top function id   
            else:
                finalResult[functionId] += (currentTime - priorTime + 1)
                stack.pop()
                priorTime = currentTime + 1
        
        #   return the resultant array.       
        return finalResult