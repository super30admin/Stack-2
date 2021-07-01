"""20. Valid Parentheses
Time Complexity: O(n)
Space Complexity: O(n)"""
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
            elif c == "{":
                stack.append("}")
            elif c == "[":
                stack.append("]")
            elif not stack or c!=stack.pop():
                return False
        if stack:
            return False
        return True
            