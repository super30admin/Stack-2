# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I store all the opening brackets in stack and whenever I encounter a closing bracket, I check if its opening counterpart is at the top of the stack.
# If at the end the stack is not empty, I return false

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for l in s:
            if l in ["(", "{", "["]:
                stack.append(l)
            else:
                if len(stack) == 0:
                    return False
                t = stack.pop()
                if l == ")" and t != "(":
                    return False
                elif l == "}" and t != "{":
                    return False
                elif l == "]" and t != "[":
                    return False
                
        if len(stack) > 0:
            return False
        else:
            return True
