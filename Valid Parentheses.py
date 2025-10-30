#  Time Complexity : O(N)   
#  Space Complexity : O(N)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code checks if a string of brackets is valid by using a stack to track opening brackets. Each time an opening bracket (, {, or [ appears, it’s pushed onto the stack, and for a closing bracket, the code checks if it correctly matches the last opening one. If all brackets match and the stack is empty at the end, the string is valid; otherwise, it’s invalid.

class Solution:
    def isValid(self, s: str) -> bool:
        # TC: O(N) SC:O(N)
        st = []

        for c in s:
            if c in "({[":
                st.append(c)
            elif not st:
                return False
            elif c == ")" and st.pop() != "(":
                return False
            elif c == "}" and st.pop() != "{":
                return False
            elif c == "]" and st.pop() != "[":
                return False
        
        return not st