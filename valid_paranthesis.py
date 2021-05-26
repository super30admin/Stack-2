# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def isValid(self, s: str) -> bool:
        if not len(s):
            return True
        stack = []
        for elem in s:
            if elem == "(":
                stack.append(")")
                
            elif elem == "{":
                stack.append("}")
                
            elif elem == "[":
                stack.append("]")
                
            elif not len(stack) or elem != stack.pop():
                return False
            
        if len(stack):
            return False
        
        return True