# Time Complexity : O(n)
# Space Complexity : O(n/2)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for c in s:
            if c == '(':
                stack.append(')')
            if c == '{':
                stack.append('}')
            if c == '[':
                stack.append(']')
            
            if (not stack) or ((c == ')' or c == '}' or c == ']') and c != stack.pop()):
                return False
            
        return len(stack) == 0