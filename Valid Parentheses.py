#time: O(n)
#space: O(1)

class Solution:
    def isValid(self, s: str) -> bool:
        d={'}':'{',')':'(',']':'['}
        st=[]
        for i in s:
            if i in d:
                if(len(st)==0 or st.pop()!=d[i]):
                    return False
            else:
                st.append(i)
        if(len(st)!=0):
            return False
        return True
                
                
        