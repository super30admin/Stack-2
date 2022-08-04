""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def isValid(self, s: str) -> bool:
        if not s or len(s) == 0:
            return True
        if len(s) % 2 != 0:
            return False

        st = []
        for i in range(len(s)):
            c = s[i]
            if c == '(':
                st.append(')')
            elif c == '{':
                st.append('}')
            elif c == '[':
                st.append(']')

            elif not st or c != st.pop():
                return False
        if len(st) != 0:
            return False
        return True

# class Solution:
#     def isValid(self, s: str) -> bool:
#         stack=[]
#         lookup={")":"(", "]":"[", "}":"{"}

#         for x in s:
#             if x in lookup.values():
#                 stack.append(x)
#             elif stack and lookup[x]== stack[-1]:
#                 stack.pop()
#             else:
#                 return False
#         return stack==[]
