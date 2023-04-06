#All TC passed on leetcode

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        #Here we traverse the logs and if its start type then we push the id into stack. 
        #We update duration for the id top of the stack by taking difference of prev time and cur time. 
        #If its end type then we pop id from the stack and update duration for the id  by taking difference of prev time and cur.
        #Time complexity: O(n) - n is number of logs 
        #Space complexity: O(n)
        res = [0]*n
        stack = []
        prev = 0

        for i in range((len(logs))):
            log = logs[i].split(":")
            id = int(log[0])
            type = log[1]
            cur = int(log[2])

            if type=="start":
                if stack:
                    res[stack[-1]]+=cur-prev
                prev = cur
                stack.append(id)
            else:
                res[stack.pop()]+= (cur+1)-prev
                prev = cur+1
        return res
                

