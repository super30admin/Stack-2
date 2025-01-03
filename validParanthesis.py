"""
keep pushing to the stack if paranthesis is open, when encountering the close paranthesis , check top of the stack if they dont match return False
Tc: O(n)
SP:O(n)
"""
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if not stack:
                stack.append(c)
            elif (c == ')' and stack[-1]=='(') or (c == '}' and stack[-1]=='{') or (c == ']' and stack[-1]=='['):
                    stack.pop()
            else:
                stack.append(c)
        return len(stack)==0
        