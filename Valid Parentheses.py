class Solution:
    def isValid(self, s: str) -> bool:
        #Approach: Stack
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        
        st = []
        pMap = {')' : '(', '}' : '{', ']' : '['}
        
        for p in s:
            if p in pMap.values():
                st.append(p)
            elif not st or not st.pop() == pMap[p]:
                return False
        
        return False if st else True