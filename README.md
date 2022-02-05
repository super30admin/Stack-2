# Stack-2

## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

# Time Complexity = O(logs)
# Space Complexity = O(n)


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        curr=0
        prev=0
        result=[0 for _ in range(n)]
        for i in logs:
            a=i.split(':')
            curr=int(a[2])
            if a[1]=='start':
                if stack: 
                    result[stack[-1]]+=curr-prev
                prev=curr
                stack.append(int(a[0]))
            else:
                result[stack.pop()]+=curr+1-prev
                prev=curr+1
        return result
                
                
            
            
            

            
        
        

## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

# Time Complexity = O(s)
# Space Complexity = O(s)

class Solution(object):
    def isValid(self, s):
        stack = []
        mapping = {")": "(", "}": "{", "]": "["}

        for char in s:
            if char in mapping:
                top_element = stack.pop() if stack else '#'
                if mapping[char] != top_element:
                    return False
            else:
                stack.append(char)
        return not stack