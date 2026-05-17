# problem 2 

# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        final_stack = []
        for i in s:
            if i in ['{','[','(']:
                final_stack.append(i)
            elif i == ']' and final_stack and final_stack[-1] == '[':
                final_stack.pop() 
            elif i == ')' and final_stack and final_stack[-1] == '(':
                final_stack.pop() 
            elif i == '}' and final_stack and final_stack[-1] == '{':
                final_stack.pop()
            else:
                return False
        if len(final_stack) == 0:
            return True 
        return False