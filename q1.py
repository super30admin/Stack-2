# Time Complexity : O(n), Where n is number of elements in the logs list 
# Space Complexity : O(n), Where n is number of elements in the logs list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=deque()
        result=[0 for _ in range(n)]
        prev=0
        
        for log in logs:
            temp=log.split(":")
            fid=int(temp[0])
            curr=int(temp[2])
                
            if(temp[1]=="start"):
                if(len(stack)!=0):
                    result[stack[-1]]+=(curr-prev)
                stack.append(fid)  
            else:
                curr+=1
                result[stack[-1]]+=(curr-prev)
                stack.pop()
            #update the prev
            prev=curr
        return result
                 
                