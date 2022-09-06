"""
Runtime Complexity: O(n) - where 'n' is the length of the string. We traverse every character in the string inorder to validate the parantheses of the given string.
Space Complexity: O(n) - stack space. If the given string only contains of opening brackets, then in the worst case we might endup storing all the chareacters in the stack.
Yes, the code worked on leetcode.
Issues while coding -No
"""

class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return False
        st = []
        for char in s:
            if char == '(':
                st.append(")")
            
            elif char == '[':
                st.append("]")
            
            elif char == '{':
                st.append("}")
            
            elif not st or char!=st[-1]:
                return False
            else:
                st.pop()
        
        return not st
                
        