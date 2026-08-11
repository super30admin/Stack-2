## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
class Solution:
    """
    Time Complexity: O(n)
    - We iterate through the string 's' of length 'n' exactly once.
    - Dictionary lookups, stack push (append), and stack pop operations run in O(1) time on average.
    
    Space Complexity: O(n)
    - In the worst-case scenario (e.g., input string containing all opening brackets like "((((("),
      the stack can store up to 'n' characters.
    - The mapping dictionary 'd' takes O(1) space since it only stores 3 fixed key-value pairs.
    """
    def isValid(self, s: str) -> bool:
        # Map closing brackets to their corresponding opening brackets
        d = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        
        # Stack to keep track of expected opening brackets in order
        stack = []
        ls = len(s)
        
        for bracket in s:
            # If the character is a closing bracket
            if bracket in d:
                # Check if the stack is non-empty and the top of the stack matches the expected opening bracket
                if stack and d[bracket] == stack[-1]:
                    stack.pop()  # Matched pair found, remove opening bracket from stack
                else:
                    return False  # Mismatched bracket or closing bracket without a matching opening bracket
            else:
                # Character is an opening bracket, push it onto the stack
                stack.append(bracket)
        
        # If the stack is empty, all opening brackets were properly closed
        return len(stack) == 0