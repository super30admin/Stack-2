#time complexity o(n)
#space complexity o(n)
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i in range(len(s)):
            if s[i] == '(':
                st.append(')')
            elif s[i] == '{':
                st.append('}')
            elif s[i] == '[':
                st.append(']')
            elif not st or s[i] != st.pop():
                return False
        
        if st:
            return False
        else:
            return True
        