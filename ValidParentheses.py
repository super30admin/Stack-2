# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We push all opening brackets to a stack and pop when we encounter a closing bracket.
# If the stack is empty or the top doesn’t match the closing bracket, it’s invalid.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        bracket_map = { ")" : "(", "}" : "{", "]" : "["}

        for ch in s:
            if ch in bracket_map:
                if not stack or bracket_map[ch] != stack.pop():
                    return False
            else:
                stack.append(ch)

        return not stack
        