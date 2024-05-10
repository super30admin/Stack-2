# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0]*n
        stack = []
        prev = 0
        for str in logs:
            splitList = str.split(":")  #[0,start,0]
            curr = int(splitList[2])
            task = int(splitList[0])
            #If stat log
            if splitList[1] == "start":
                #pause the prev task in stack
                #record it's time
                if stack:
                    res[stack[-1]]+= curr-prev
                prev = curr
                stack.append(task)
            #If end log
            else:
                res[stack.pop()]+= curr + 1 - prev
                prev = curr+1
        return res
            


        