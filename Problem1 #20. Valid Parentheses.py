# Time Complexity: O(N)
# Space Complexity: O(1)

class Solution:
    def isValid(self, s: str) -> bool:
        if s is None:
            return True

        stack = []
        for i in range(len(s)):
            c = s[i]
            if c == '(':
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            elif not stack or c != stack.pop():
                return False
            else:
                stack.pop()

        return stack is None
