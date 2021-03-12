# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Use Stack to store the IDS of processes. parse each process
# if Start: then put into the stack keep cur and prev values to calculate the time
# for each peek in stack we update res with cur-prev
# If End: pop from the stack and update in the res with cur-prev+1

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs == None: return
        stack = []
        prev = 0
        res = [0]*n
        
        for i in logs:
            prs = i.split(":") #["ID", "process","Time"]
            cur = int(prs[2])
            if prs[1] == "start":
                if stack:
                    res[stack[-1]] += cur - prev
                    prev = cur
                stack.append(int(prs[0]))
            else:
                res[stack.pop()] += cur-prev+1
                prev = cur+1
        return res
                
            
        
        
        
        