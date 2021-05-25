## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n==0 or len(logs)==0:
            return []
        result = [0] * n
        stack = []
        strArray = []
        prev = 0
        for log in logs:
            strArray = log.split(":")
            # print(strArray)
            curr = int(strArray[2])
            if strArray[1]=="start":
                if len(stack)!=0:
                    a = stack[-1]
                    result[a] = result[a] + curr - prev
                    prev = curr
                stack.append(int(strArray[0]))
            else:
                result[stack.pop()] += curr - prev +1
                prev = curr +1
        return result
#Time Complexity: O(m) m - length of log
#Space Complexity: O(m)
#Approach: Use stack, Split the incoming string using ':' as the seperator. Push and pop accordingly untill the entire string is parsed. 
