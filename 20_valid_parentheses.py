"""
Leetcode: https://leetcode.com/problems/valid-parentheses/
Approach:
    - Use stack to store all opening brackets.
    - Use hashmap to store closing bracket to opening bracket mapping
    - Iterate given string, if char exists in map i.e. closing bracket, top element from stack
        should be an equivalent opening bracket.

Time complexity : O(n) because we simply traverse the given string one character at a time
    and push and pop operations on a stack take O(1) time.
Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
    we will end up pushing all the brackets onto the stack.
"""


class Solution(object):
    def isValid(self, s):
        # The stack to keep track of opening brackets.
        stack = []

        # Hash map for keeping track of mappings. It will help to add more types of parenthesis
        mapping = {")": "(", "}": "{", "]": "["}

        # For every bracket in the expression.
        for char in s:

            # If the character is an closing bracket
            if char in mapping:

                # Pop the topmost element from the stack, if it is non empty
                # Otherwise assign a dummy value of '#' to the top_element variable
                top_element = stack.pop() if stack else '#'

                # The mapping for the opening bracket in our hash and the top
                # element of the stack don't match, return False
                if mapping[char] != top_element:
                    return False
            else:
                # We have an opening bracket, simply push it onto the stack.
                stack.append(char)

        # If the stack is empty, then we have a valid expression.
        return not stack