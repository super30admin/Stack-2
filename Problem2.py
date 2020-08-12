"""
// Time Complexity : o(n), n->lenght of string
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        st = []
        for i in s: #for every opeing bracket add corresponding closing bracket into the stack
            if i == "(":
                st.append(")")
            
            elif i == "{":
                st.append("}")
                
            elif i == "[":
                st.append("]")
                
            else: #when closing brackets are encountered
                if not st or st.pop() != i: #if stack is empty, i.e. there was no opening bracket encountered or there is a mismatch return false
                    return False
                
        if not st: #if in the stack is empty, return true
            return True