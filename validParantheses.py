#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i in range(len(s)):
            if s[i] == '{':
                st.append('}')
            elif s[i] == '[':
                st.append(']')
            elif s[i] == '(':
                st.append(')')
            elif (not st or st[-1] != s[i]):
                return False
            elif (st[-1] == s[i]):
                st.pop()
        
        return not st
            
        