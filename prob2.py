# Time Complexity :  O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def isValid(self, s: str) -> bool:

        mapper = {'(':')', '{':'}', '[':']'}
        l = []
        
        for i in range(len(s)):
            if len(l) ==0 and s[i] in '}])':
                return False
            if s[i] in mapper:
                l.append(s[i])
            elif mapper[l[-1]] == s[i]:
                l.pop()
            else:
                return False
        if len(l) == 0:
            return True