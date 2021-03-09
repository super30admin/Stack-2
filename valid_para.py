'''
# Time complexity - O(N) : N is no.of char in str
# Space Complexity: O(N) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Push the bracket when open and pop it when closed.
'''
class Solution:
    def isValid(self, s: str) -> bool:
        if s is None or len(s) == 0 or len(s) % 2 != 0:
            return False
        
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
                
            elif c == "{":
                stack.append("}")
                
            elif c == "[":
                stack.append("]")
            
            elif len(stack) == 0 or stack.pop() != c:
                return False
            
        if len(stack) != 0:
            return False
        
        return True