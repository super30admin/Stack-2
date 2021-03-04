#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)==0:
            return False
        st=[]                           #stack array is created
        for b in s:                     
            if b=='(':                  #if open brackets are encountered, add closing brackets in stack
                st.append(')')
            elif b=='[':
                st.append(']')
            elif b=='{':
                st.append('}')
            elif not st or st.pop()!=b:         #if closing bracket is encountered and top of the stack is not the same bracket return false
                return False
        if st:
            return False
        return True
                