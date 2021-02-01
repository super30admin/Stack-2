"""
Approach: Stack

1)Initialize a stack S.
2) Process each bracket of the expression one at a time.
3) If we encounter an opening bracket, we simply push it onto the stack. This means we will process it later, let us simply move onto the sub-expression ahead.
4)If we encounter a closing bracket, then we check the element on top of the stack. If the element at the top of the stack is an opening bracket of the same type, then we pop it off the stack and continue processing. Else, this implies an invalid expression.
5) In the end, if we are left with a stack still having elements, then this implies an invalid expression.

TC: O(n)
SC: O(n)

n = length of s
"""

class Solution:
    def isValid(self, s: str) -> bool:
        if s == None or len(s) == 0:
            return True
        
        stack = []
        dic = {"(": ")",
               "{": "}",
              "[": "]"}
        
        for i in s:
            if i == "{" or i == "[" or i == "(":
                stack.append(i)
            else:
                if stack:
                    char = stack.pop()
                    if dic[char] != i:
                        return False
                else:
                    return False
        
        if len(stack):
            return False
        return True
                
        