# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValid(self, s: str) -> bool:
        # Stack to keep track of opening brackets
        stack = []
        
        # Dictionary to map closing brackets to their corresponding opening brackets
        bracket_map = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        
        # Iterate through each character in the string
        for char in s:
            # If it's an opening bracket, push to stack
            if char in '({[':
                stack.append(char)
            # If it's a closing bracket
            elif char in ')}]':
                # If stack is empty, there's no matching opening bracket
                if not stack:
                    return False
                # Check if the top of stack matches the expected opening bracket
                if stack.pop() != bracket_map[char]:
                    return False
        
        # After processing all characters, stack should be empty
        return len(stack) == 0
        