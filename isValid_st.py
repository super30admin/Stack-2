"""
Time complexity O(N)
Space complexity O(N)

-when ever u encounter opening braces of any kind push a closing onto stack
-when you encounter closing braces and check them with top of stack if they are same kind , else return False

"""

class Solution:
    def isValid(self, s: str) -> bool:
        st =[]
        for ch in s:
            if ch=='(':
                st.append(')')
            elif ch=='[':
                st.append(']')
            elif ch=='{':
                st.append('}')
            elif (len(st)==0 or st.pop() !=ch):
                return False
            
        if st:
            return False
        return True
        