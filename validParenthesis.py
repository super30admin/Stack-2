"""
Stack Approach --
TC - O(n)
SC - O(n)
"""
class Solution:
    def isValid(self, s: str) -> bool:
        if s is None or len(s) == 0: return True
        mstack = deque()

        for i in range(len(s)):
            if s[i] == '(':
                mstack.append(')')
            elif s[i] == '{':
                mstack.append('}')
            elif s[i] == '[':
                mstack.append(']')
            elif len(mstack) == 0 or mstack[-1] != s[i]:
                return False
            else:
                mstack.pop()

        return len(mstack) == 0