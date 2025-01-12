#Approach
# We need to save the previous comuted time to solve the present and save it in the previous

#Complexities
#Time: O(n)
#Sapce: O(N)


from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prevtime =0
        for log in logs:
            splitArr = log.split(":")
            processId, action, currtime = int(splitArr[0]), splitArr[1], int(splitArr[2])

            if action=="start":
                if stack:
                    result[stack[-1]]+= currtime-prevtime
                stack.append(processId)
                prevtime = currtime
            else:
                result[stack[-1]] += currtime-prevtime+1
                stack.pop(-1)
                prevtime = currtime+1



        return result




s =  Solution()
s.exclusiveTime(1,["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"])

