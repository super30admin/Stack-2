# The isValid method checks if a string containing brackets is valid.

# Use a stack to track open brackets:
# - For each closing bracket, check if the top of the stack matches the corresponding opening bracket.
# - If it matches, pop the stack; otherwise, return False.
# - Push open brackets onto the stack.

# After traversal, the string is valid if the stack is empty.

# TC: O(n) - Single pass through the string.
# SC: O(n) - Space for the stack.


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closeToOpen = { ")" : "(", "]" : "[", "}" : "{" }

        for c in s:
            if c in closeToOpen:
                if stack and stack[-1] == closeToOpen[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        
        return True if not stack else False