# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def isValid(self, s: str) -> bool:

        if not s or len(s) == 0:
            return True

        st = []
        mp = {')': '(', ']': '[', '}': '{'}

        for i in s:
            if i in mp:
                if not (st and st.pop() == mp[i]):
                    return False
            if i not in mp:
                st.append(i)

        return not st 
