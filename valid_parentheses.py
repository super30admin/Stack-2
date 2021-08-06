# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        n = len(s)
        for i in range(n):
            c = s[i]
            if c == '(':
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            elif not stack or stack.pop() != c:
                return False

        if len(stack) == 0:
            return True
        return False