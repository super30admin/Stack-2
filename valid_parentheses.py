# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        if not s: return
        
        stack = []
        
        for bracket in s:
            if bracket == '(' or bracket == '{' or bracket == '[':
                stack.append(bracket)
            else:
                if not stack: return False
                popped = stack.pop()
                if bracket == ')' and popped != '(': return False
                if bracket == '}' and popped != '{': return False
                if bracket == ']' and popped != '[': return False
        
        if not stack:
            return True
        else:
            return False