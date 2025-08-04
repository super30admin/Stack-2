# Stack to check what was the last incoming bracket
# O(n) and O(n) for different type of bracket

class Solution:
    def isValid(self, s: str) -> bool:
        if not s or len(s)%2 !=0:
            return False
        stack = []
        for char in s:
            if char == '(':
                stack.append(')')
            elif char == '{':
                stack.append('}')
            elif char == '[':
                stack.append(']')
            elif not stack or char != stack.pop():
                return False
        return not stack