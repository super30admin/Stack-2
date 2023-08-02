
'''
Problem: Valid Paranthesis
Time Complexity: O(n), where n is given elements
Space Complexity: O(n) for stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Append char in the stack, as soon as closing is encountered pop
        at the end , check if stack is empty or not    
'''

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in range(len(s)):
            if s[i] == "(":
                stack.append(")")
            elif s[i] == "[":
                stack.append("]")
            elif s[i] == "{":
                stack.append("}")
            else:
                if stack and s[i] == stack[-1]:
                    stack.pop()
                else:
                    return False

        if len(stack)==0:
            return True
        else:
            return False