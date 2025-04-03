#  https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(')')

            elif s[i] == '[':
                stack.append(']')

            elif s[i] == '{':
                stack.append('}')
            
            elif not stack or stack[-1] != s[i]:
                return False
            
            elif stack[-1] == s[i]:
                stack.pop()
        
        return not stack

# TC: O(n)
# SC: O(n)