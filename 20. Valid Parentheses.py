'''
T = O(n)
S = O(n)

Approach:
Keep inserting the closing brakets if an openeing bracket is encountered
whenever its correcsponding closing paranthsis is not found in the string that means that
the current paranthesis is not resolved so return false. else when all the paranthesis are
resolved return True when the stack length is zero
'''


class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        
        stack = []
        
        for i in range(0,len(s)):
            if s[i] == '(':
                stack.append(')')
            elif s[i] == '{':
                stack.append('}')
            elif s[i] == '[':
                stack.append(']')
            elif len(stack)==0 or s[i]!=stack.pop():
                return False
        
        if stack:
            return False
        return True