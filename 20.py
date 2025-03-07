class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return False
        stack = []
        for char in s:
            if char == "(":
                stack.append(")")
            elif char == "{":
                stack.append("}")
            elif char == "[":
                stack.append("]")
            else:
                if not stack  or char != stack[-1]:
                    return False
                else:
                    stack.pop()
        return len(stack) == 0
    # TC : O(n)
    # SC : O(n)
