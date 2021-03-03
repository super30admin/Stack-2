# Approach: for every open braces push the closing one to the stack 
# when encountering the closing one check from stack if they are the same

# Time - O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        
        st = []
        for char in s:
            
            if char == '{':
                st.append('}')
                
            elif char == '(':
                st.append(')')
                
            elif char == '[':
                st.append(']')
                
            elif st == [] or char != st.pop():
                return False
         
        if st:
            return False
        return True
        