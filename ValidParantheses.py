# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i]=='(':
                stack.append(')')
            elif s[i]=='[':
                stack.append(']')
            elif s[i] == '{':
                stack.append('}')
            elif len(stack) == 0 or s[i]!=stack.pop():
                return False
        return len(stack) == 0

    