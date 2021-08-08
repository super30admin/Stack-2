from typing import List
from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        st = deque()
        # for i in range(len(s)):
        #     if s[i] == '(' or s[i] == '[' or s[i] == '{':
        #         st.append(s[i])
        #         continue
        #     if len(st) > 0:
        #         if (s[i] == ')' and st[-1] == '(') or (s[i] == ']' and st[-1] == '[') or (s[i] == '}' and st[-1] == '{'):
        #             st.pop()
        #         else:
        #             return False
        #     else:
        #         return False
        # if len(st) == 0:
        #     return True
        # else:
        #     return False
        for i in range(len(s)):
            if s[i] == '(':
                st.append(')')
            elif s[i] == '{':
                st.append('}')
            elif s[i] == '[':
                st.append(']')
            else:
                if len(st) == 0 or s[i] != st.pop():
                    return False
        if len(st) > 0:
            return False
        return True

# Time Complexity: O(n)
# Space Complexity: O(n)