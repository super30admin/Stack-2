# Approach:
# - Use a stack to keep track of open brackets.
# - Iterate through the string and push open brackets onto the stack.
# - For closing brackets, check if the stack is not empty and if the top of the stack matches the closing bracket.
# - If it matches, pop the stack; otherwise, return False.
# - At the end, the stack must be empty for the string to be valid.

# Time Complexity: O(N), where N is the length of the string.
# Space Complexity: O(N), for the stack in the worst case if all characters are open brackets.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def isValid(self, s: str) -> bool:
        # Dictionary to map closing brackets to their corresponding opening brackets
        bracket_map = {')': '(', '}': '{', ']': '['}
        # Stack to keep track of open brackets
        stack = []

        for char in s:
            if char in bracket_map:
                # If it's a closing bracket, check the top of the stack
                top_element = stack.pop() if stack else '#'
                if bracket_map[char] != top_element:
                    return False
            else:
                # If it's an opening bracket, push it onto the stack
                stack.append(char)

        # The stack should be empty if all brackets are matched
        return not stack
