#Exclusive time of function
# // Time Complexity : O(max(N, len(logs))
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        res=[0]*n
        prev=0
        for i in logs:
            ss=i.split(":")
            curr = int(ss[2])
            if ss[1]=="start":              #if there is something in the stack, and the current function is start, then find the difference and add it to the top stack value
                if stack:
                    res[stack[-1]] += curr - prev
                stack.append(int(ss[0]))
                prev=curr
            else:                           #if its end, then pop the top and then find the difference between current and previous and add it to the result
                res[stack.pop()]+=(curr+1)-prev
                prev=curr+1
        return res
                
                
            
        
        
        