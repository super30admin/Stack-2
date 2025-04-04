# Problem 2 : Valid Parentheses
# Time Complexity : O(n) where n is the length of the string s
# Space Complexity : O(n) where n is the length of the string s
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def isValid(self, s: str) -> bool:
        # define stack for storing the parenteses
        stack = []
        # loop through each character in string s
        for c in s:
            # if c is ( then append ) to the stack
            if c == '(':
                stack.append(')')
            # if c is { then append } to the stack
            elif c == '{':
                stack.append('}')
            # if c is [ then append ] to the stack
            elif c == '[':
                stack.append(']')
            # if the stack is empty or the top element is equal to character then return False
            elif not stack or c != stack.pop():
                return False

        # if the stack is not empty then return False
        if stack:
            return False
        # return True
        return True
