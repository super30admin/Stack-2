# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(N) where N is length of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 == 1:
            return False
        stack = []
        for bracket in s:
            if bracket == "(":
                stack.append(")")
            elif bracket == "{":
                stack.append("}")
            elif bracket == "[":
                stack.append("]")
            elif len(stack) == 0 or stack[-1] != bracket:
                return False
            else:
                stack.pop()
            
        if len(stack) != 0: return False
        return True