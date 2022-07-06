'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i in range(len(s)):
            if(s[i] == '('): st.append(')')
            elif(s[i] == '['): st.append(']')
            elif(s[i] == '{'): st.append('}')
            elif(len(st)!=0 and st[-1]==s[i]):
                st.pop()
            else:
                return False
        return len(st)==0
        