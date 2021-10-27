# // Time Complexity :O(n),len of s
# // Space Complexity :O(n),height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def isValid(self, s: str) -> bool:
        st=[]
        
        for i in range(len(s)):
        
            if s[i]=='(':
                st.append(')')
            
            elif s[i]=='[':
                st.append(']')
            elif s[i]=='{':
                st.append('}')
            else:
                if len(st)==0 or s[i] != st[-1]:
                    return False
                st.pop()
        return len(st)==0