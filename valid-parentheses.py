#tc = O(n)
#sc = O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in range(len(s)):
            if s[i] == '(':
                stack.append(')')
            elif s[i] == '{':
                stack.append('}')
            elif s[i] == '[':
                stack.append(']')
            elif len(stack) == 0 or s[i] != stack.pop():
                return False
            
        return len(stack) == 0 
