#Time, space O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        
        map={"(":")","{":"}","[":"]"}
        open=["{","[","("]
        
        st=[]
        #Traversing string and adding the open brackets in stack whenevere we find closing braces we pop
        for i in s:
            if i in open:
                st.append(i)
            elif st and i==map[st[-1]]:
                st.pop()
            else:
                return False
            
        return st==[]
