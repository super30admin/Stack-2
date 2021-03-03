#Time Complexity -- O(N)
#Space Complexity -- O(N)

class Solution:
    def isValid(self, s: str) -> bool:
        
        if not s:
            return False
        
        stack = []
        for c in s:
            if c == '[':
                stack.append(']')
            elif c == '(':
                stack.append(')')
            elif c == '{':
                stack.append('}')
            elif not stack or c != stack.pop():
                return False
            
        if stack:
            return False
        
        return True
