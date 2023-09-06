#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def isValid(self, s: str) -> bool:
        map={'(':')','{':'}','[':']'}
        st=[]
        for c in s:
            if c in map.keys():
                st.append(c)
            elif st and map[st[-1]]==c:
                st.pop()
            else: 
                return False
        return not st