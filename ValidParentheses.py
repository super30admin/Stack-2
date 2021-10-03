"""
Time Complexity : O(n) where n is the length of the string
Space Complexity : O(n) where n is the length of the string
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return True
        stack = []
        # For every open parentheses we push a closing parentheses into the stack. 
        # Whenever a parentheses that is equal to the element on top of stack we pop
        # the element from the stack. At the end if the stack is empty we return true
        # which means it is valid and false if not i.e invalid
        for i in range(len(s)):
            c = s[i]
            if c == "(":
                stack.append(")")
            elif c == "[":
                stack.append("]")
            elif c == "{":
                stack.append("}")
            else:
                if not stack or c != stack.pop(): return False
        return len(stack) == 0
                