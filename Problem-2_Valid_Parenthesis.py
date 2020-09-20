# APPROACH 1a. Stack solution
# Time Complexity : O(n), n: length of s
# Space Complexity : O(n), space of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Store the bracket pairs in a hashmap
# 2. For each opening bracket, push it in stack
# 3. If a closing bracket, check if it's the pair of stack's top -> Yes, pop off from stack and move to next char
#                                                                -> No, then it's INVALID


class Solution:
    def isValid(self, s: str) -> bool:
        
        if s is None or len(s) < 2:
            return False
        
        stack = []
        hashmap = {'[': ']', '(': ')', '{': '}'}
        
        for char in s:
            if char in hashmap.keys():
                stack.append(char)
            else:
                if len(stack) > 0 and hashmap[stack[-1]] == char:
                    stack.pop()
                else:
                    return False
         
        if len(stack) == 0:
            return True
        else:
            return False
            
            
   
   
# APPROACH 1.b) Stack solution
# Time Complexity : O(n), n: length of s
# Space Complexity : O(n), space of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as above approach. Only difference is instead of maintaing a hashmap, here we don't use one
# 2. If a open bracket, push it's pair instead of the close one. 
# 3. If a close bracket, check if it's equal to the stack's top. 

            
 class Solution:
    def isValid(self, s: str) -> bool:
        
        if s is None or len(s) < 2:
            return False
        
        stack = []
        
        for char in s:
            if char == '(':
                stack.append(')')
            elif char == '[':
                stack.append(']')
            elif char == '{':
                stack.append('}')
                
            elif len(stack) > 0 and stack[-1] == char:
                stack.pop()
            else:
                return False
         
        if len(stack) == 0:
            return True
        else:
            return False
