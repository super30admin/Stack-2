'''
Using Stack
It can also be solved with single count variable but only if we have one type of parenthesis, if there are multiple types, we can't keep trace of the order so stacks will be the efficient choice
Time: O(n)
Space: O(n), for stack
'''


class Solution:
    def isValid(self, s: str) -> bool:
        st = list()
        for i in range(len(s)):
            if s[i] == '(':
                st.append(')')
            elif s[i] == '[':
                st.append(']')
            elif s[i] == '{':
                st.append('}')
            elif len(st) == 0 or st.pop() != s[i]:
                return False
        
        if len(st) != 0:
            return False
        
        return True