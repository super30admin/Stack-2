"""
Time Complexity : O(n)
Space Complexity : O(n)
"""


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for char in s:
            if char == "(":
                stack.append(")")
            elif char == "{":
                stack.append("}")
            elif char == "[":
                stack.append("]")
            elif char == ")":
                if not stack or (stack and stack[-1] != ")"):
                    return False
                else:
                    stack.pop()
            elif char == "}":
                if not stack or (stack and stack[-1] != "}"):
                    return False
                else:
                    stack.pop()
            elif char == "]":
                if not stack or (stack and stack[-1] != "]"):
                    return False
                else:
                    stack.pop()
        return not stack
