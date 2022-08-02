#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        pMap = {')':'(', '}':'{', ']':'['}
        st = []
        
        for i in range(len(s)):
            if s[i] == '(':
                st.append(s[i])
            elif s[i] == '{':
                st.append(s[i])
            elif s[i] == '[':
                st.append(s[i])
            if s[i] == ')' or s[i] == '}' or s[i] == ']':
                if not st or st.pop() != pMap[s[i]]:
                    return False
        if st:
            return False
        return True
                
        
