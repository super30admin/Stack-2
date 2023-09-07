# TC-O(n), n is number of logs
# SC-O(e), e is number of different tasks
class Solution:
    def exclusiveTime(self,n, logs):
        res = [0] * n
        prevtime = 0
        stack = []

        for log in logs:
            logParts = log.split(":")
            functionId, eventType, timestamp = int(logParts[0]), logParts[1], int(logParts[2])
            if eventType=='start': #if it's a start-> calculate the time run for prevously running task and push this task to stack. Also keep track of previous timetamp
               if stack:
                   res[stack[-1]]+=timestamp-prevtime
               stack.append(functionId)
               prevtime=timestamp
            else: #here, +1 cause all 'start's start at left bound of a box and all 'end's end at right bound of a box. example, 2:start:1 and 2:end:1 is a valid log-> it started at left bound of time 1 box and ended at right bound of time 2 box. ->it ran for 1 time unit, so (1+1)-1=1

            #for end->pop the top of stack, that is currently running task and calculate it's time.
                res[stack.pop()]+=timestamp-prevtime+1
                prevtime=timestamp+1
        return res 
            