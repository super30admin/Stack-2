# Time Complexity: O (n)(Where n is length of string) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# If left brackets are encountered, add it to the stack. If right bracket is encountered pop the stack and compare it. 
# If comparison is false than we don't have valid parentheses. At the end If we don't have empty stack that also means we don't have valid parentheses.
class Solution:
    def isValid(self, s: str) -> bool:
#       Cover edge cases
        if len(s) < 1:
            return True
        if len(s) < 2:
            return False
#       For fast access of different brackets
        revstore = {
            "}": "{",
            "]": "[",
            ")": "("
        }
        
#       Initialize stack
        stack = []
        
#       Iterate over evry charcter
        for char in s:
#           If char is left bracket
            if char not in revstore:
                stack.append(char)
#           If char is right bracket
            else:
#           pop the elemnet if stack is not empty, also pop can come even if stack is empty. So assign any character except given brackets to the popped variable.
                if stack:
                    comp = stack.pop()
                else:
                    comp = "#"
#               Compare popped element
                if revstore[char] != comp:
                    return False
#       In the end check that stack is empty or not
        if len(stack) == 0:
            return True
        else:
            return False
        
