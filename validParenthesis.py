# // Time Complexity :O(n) 1 pass
# // Space Complexity :O(n) n/2 worst for every bracket
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# we use a stack to store all different brackets. at some point we will find closing brackets we need to tcheck if it is correct peek element.
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        n = len(s)
        if n < 2: return False              # if length is less than 2, 

        for i in range(n):
            c = s[i]

            if c=='(':
                st.append(')')
            elif c=='{':
                st.append('}')            
            elif c=='[':
                st.append(']')
            elif not st or c != st.pop():   # if stack has items and the current closing bracket is not the same as top of stack
                return False
                

        return not st                       # stack should be empty