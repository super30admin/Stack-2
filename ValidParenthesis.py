#Time Compelxity : O(n)
#Space Complexity : O(n)
    
    
class Solution:
    def isValid(self, s: str) -> bool:
        #if len(s) % 2 != 0:
        #    return False

        st = []
        for i in s:
            if i == '(':
                st.append(')')

            elif i == '{':
                st.append('}')

            elif i == '[':
                st.append(']')

            elif len(st) == 0 or st.pop() != i:
                return False

        if len(st) == 0:
            return 