'''
Time Complexity - O(n). We are traversing through all characters of an input
Space Complexity - O(n). We are using a stack.
Works on Leetcode
'''
from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        expr_stack = deque()
        for c in s:
            #if opening paranthesis push in stack 
            if c == '(':
                expr_stack.append(')')
            elif c == '{':
                expr_stack.append('}')
            elif c == '[':
                expr_stack.append(']')
            else: 
            #if closing paranthesis check top of stack, if match then pop else invalid paranthesis
                if not expr_stack or c != expr_stack[-1]:
                    return False
                else:
                    expr_stack.pop()
        if not expr_stack:
            return True
        else:
            return False
