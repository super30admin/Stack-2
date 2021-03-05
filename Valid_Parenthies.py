"""
Time Complexity : O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
If we find an opening bracket, just put the corresponding closing  in stack. If its closing, check top 
of stack. If they are not equal, return false. Also, if stack is empty and we encounter a closing brace,
its invalid. After iterating through the whole string, if stack still has values, the string is invalid.
"""


class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        stack = []
        for i in s:
            if i == '(':
                stack.append(')')
            elif i == '{':
                stack.append('}')
            elif i == '[':
                stack.append(']')
            elif not stack or i != stack.pop():
                return False
        if stack:
            return False
        return True
      
      
# Using Dictionary
class Solution:
    def isValid(self, s: str) -> bool:
        #base case with odd form
        if s == 0 or len(s) % 2 != 0:
            return False
        
        stack = []
        dic = {')':'(', '}':'{', ']':'['}
        
        for char in s:
            if char in dic:
                if not stack or dic[char] != stack.pop():
                    return False
            else:
                stack.append(char)
        
        if not stack:
            return True
        return False
         
