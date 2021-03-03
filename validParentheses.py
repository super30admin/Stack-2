# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {'(' : ')', '{' : '}', '[' : ']'}
        count = 0
        for i in range(len(s)):
            if s[i] in mapping:
                stack.append(s[i])
            elif not stack or mapping[stack.pop()] != s[i]:
                return False
            count += 1
        if stack:
            return False
    
        return True
                