#Time Complexity : O(n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def isValid(self, s: str) -> bool:
        st = deque()
        hm = { ')':'(', '}':'{', ']':'['}
        for i in s:
            if i in ['(', '{', '[']:
                st.append(i)
            else:
                if len(st) == 0:
                    return False
                else:
                    if st[-1] == hm[i]:
                        st.pop()
                    else:
                        return False
        if len(st) == 0:
            return True
        else:
            return False