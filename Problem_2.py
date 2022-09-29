"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach
Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
"""

class Solution:
    def isValid(self, s: str) -> bool:
        """
        TC: O(N) len of the string
        SC: O(N) len of the string
        """
        if s is None or len(s) == 0: return True
        
        # if the string is of odd length
        if len(s)% 2 != 0 : return False
        
        stack = []
        
        for c in s:
            if c == "(": stack.append(")")
            elif c == "{" : stack.append("}")
            elif c == "[" : stack.append("]")
            elif not stack or c != stack.pop(): return False
        
        if stack : return False
        
        return True
            
        