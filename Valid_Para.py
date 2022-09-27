# Time complexity : O(L)
# Space complexity : O(L)
# Leetcode : Solved and submitted

class Solution:
    def isValid(self, s: str) -> bool:
        # maintain a stack as we need to balance the parantheses
        st = []
        
        # check for null cases and also if the lenght is not even then return False
        if not s or len(s) == 0 or len(s)%2 != 0:
            return False
        
        # traverse through the len of s
        for i in range(len(s)):
            ch = s[i]
            # foe every opening brace, we push the closing bracket onto the stack so that comparing is easy and no need for a mapping
            if ch == '(':
                st.append(')')
            elif ch == '[':
                st.append(']')
            elif ch == '{':
                st.append('}')
            
            # if the stack is empty or the popped char from stack is not the expected bracket in sequence, return False
            elif not st or st.pop() != ch:
                return False
        # if stack has some elements, which means the string is not balanced, so return False
        if st:
            return False
         
        # return True if the complete string is balanced
        return True
                
