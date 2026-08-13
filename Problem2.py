# Problem2: Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
# Time Complexity: O(n),We loop through the string once and each push or pop is O(1)
# Space Complexity: O(n),In the worst case every character is an opening bracket and gets pushed onto the stack
# Approach
# We use a stack to keep track of opening brackets we have seen but not yet closed
# When we see a closing bracket we check if it matches the most recent opening bracket on top of the stack
# If it matches we pop it off since that pair is now resolved
# If it does not match or the stack is empty we know the string is invalid
# At the end if the stack is empty it means every opening bracket was properly closed

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []   # this will hold opening brackets that are waiting to be closed

        for char in s:       # go through the string one character at a time

            if char in "([{":
                stack.append(char)
                # it is an opening bracket so we do not know yet if it will be closed correctly
                # we push it onto the stack to check later when we see its matching closing bracket

            elif not stack:
                return False
                # the character must be a closing bracket at this point
                # if the stack is empty there is no opening bracket to match it with
                # so the string cannot be valid

            elif char == ")" and stack.pop() != "(":
                return False
                # char is a closing round bracket
                # we pop the top of the stack and check if it was the matching opening bracket
                # if it was not a match the string is invalid

            elif char == "}" and stack.pop() != "{":
                return False
                

            elif char == "]" and stack.pop() != "[":
                return False
               

        return not stack
        # if the stack is empty every opening bracket was matched and popped so the string is valid
        # if something is still left in the stack some opening bracket was never closed