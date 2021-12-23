# 20. Valid Parentheses
# https://leetcode.com/problems/valid-parentheses/

# Logic: Use a stack to store the opening brackets and when you get 
# a closing bracket check the top of the stack. If the top is of the 
# same type, pop out of the stack. At the end check if the stack is 
# empty or not.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        bracket = {
            ')':'(',
            ']':'[',
            '}':'{'
        }
        
        if len(s) == 0 or s[0] in ')]}':
            return False
        
        for item in s:
            if item in '([{':
                stack.append(item)
            elif item in ')]}':
                if len(stack) !=0 and stack[-1] == bracket[item]:
                    stack.pop()
                else:
                    return False
        
        return len(stack) == 0