# // Time Complexity :o(n)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We push the expected closing bracket to the stack for every opening bracket.
# For every closing bracket, we check if it matches the top of the stack; if not, it’s invalid.
# If the string has only one type of parenthesis (like just '(' and ')'), we can use a simple count variable instead of a stack.

class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for c in s:
            if c == '(':
                st.append(')')
            elif c == '{':
                st.append('}')
            elif c == '[':
                st.append(']')
            elif not st or c!=st.pop():
                return False
        return not st
        