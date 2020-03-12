class Solution:
    def isValid(self, s: str) -> bool:
        """
            https://leetcode.com/problems/valid-parentheses/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of list 's'.
        """
        if not s:
            return True
        if len(s) % 2 != 0:
            return False

        stack = []
        for c in s:
            if c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            elif c == '(':
                stack.append(')')
            elif not stack or stack.pop() != c:
                return False
        if stack:
            return False
        return True
