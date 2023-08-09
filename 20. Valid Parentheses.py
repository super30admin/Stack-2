# Time and Space complexity : O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []  # Create an empty stack to store parentheses
        
        # Iterate through each character in the input string
        for c in s:
            if c == '(':  # If an opening parenthesis is encountered, push the corresponding closing parenthesis onto the stack
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            else:  # If a closing parenthesis is encountered
                # Check if the stack is empty or the current character doesn't match the top of the stack
                if len(stack) == 0 or c != stack.pop():
                    return False  # Return False if the parentheses are not balanced
        
        # Return True if the stack is empty (all parentheses are balanced), False otherwise
        return len(stack) == 0

