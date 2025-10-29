"""
TC: O(N) {We iterate through the string once. Each character is pushed onto and popped from the stack at most once, 
          resulting in a linear time complexity.}
SC: O(N) {In the worst case, when all characters are opening brackets, the stack will hold N elements, 
          leading to linear space complexity.}

Approach:
We are tasked with determining whether a string containing various types of parentheses — '()', '{}', and '[]' — 
is valid. A valid string must have all opening brackets properly closed in the correct order and type.

We use a stack to validate the sequence of parentheses:
    - We iterate through each character in the string.
    - If the character is a closing bracket, we check whether the stack is non-empty and whether the top of the stack 
      contains its corresponding opening bracket. If not, the string is invalid.
    - If it matches, we pop the top element from the stack.
    - If the character is an opening bracket, we push it onto the stack.

After processing all characters, the string is valid only if the stack is empty — meaning all opening brackets 
have been properly closed in the correct order.

This approach efficiently handles nested and sequential parentheses of different types.

This problem ran successfully on Leetcode.
"""
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closed = {"}" : "{", ")": "(", "]": "["}

        for curr in s:
            
            if curr in closed:
                if not stack or closed[curr] != stack[-1]:
                    return False
                stack.pop()
            else:
                stack.append(curr)
        
        return not stack