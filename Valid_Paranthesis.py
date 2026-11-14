# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap and stack
# initialize HashMap with all the brackets
# Iterate over the string and check if it exists in dict
# If yes then append the value to stack
# If no then check if stack is not empty and if the stack[-1] == string then pop the stack
# If it doesnt match return False
# Return True if stack is empty and no string left in stack


class Solution:
    def isValid(self, s: str) -> bool:
        pdict = {
            '(':')',
            '{':'}',
            '[':']'
        }
        stack = []
        for i in range(len(s)):
            if s[i] in pdict:
                stack.append(pdict[s[i]])
            elif stack and s[i] == stack[-1]:
                stack.pop()
            else:
                return False
        return not stack