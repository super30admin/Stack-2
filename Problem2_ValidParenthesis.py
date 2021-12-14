# Time Complexity: O(n), where n is the number of chars in the input string
# Space Complexity: O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        if not s or len(s) == 0:
            return True

        stack = []

        for ch in s:
            # If the char is opening bracket, push its corresponding closing bracket into the stack
            if ch == '(':
                stack.append(')')
            elif ch == '[':
                stack.append(']')
            elif ch == '{':
                stack.append('}')

            # If the char is closing bracket and if there is no corresponding bracket in the stack, return not valid
            elif len(stack) == 0 or ch != stack.pop():
                return False

        # If the stack is empty, the input string is valid
        return len(stack) == 0


