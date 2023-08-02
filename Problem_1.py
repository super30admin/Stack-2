"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Exclusive Time of Functions

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        if not logs:
            return [0]
        
        result=[0 for _ in range(n)]
        stack=[]
        curr=0
        prev=0
        # stack.append(0)
        for log in logs:
            strArr=log.split(":")
            currId=int(strArr[0])
            curr=int(strArr[2])
            if strArr[1]=="start":
                if stack:
                    result[stack[-1]]+=curr-prev
                stack.append(currId)
                prev=curr
            elif strArr[1]=="end":
                result[stack.pop()]+=curr+1-prev
                prev=curr+1
        return result