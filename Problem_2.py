"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Valid Parentheses

# Approach - 1

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s:
            return True
        st=[]
        for i in range(len(s)):
            c=s[i]
            if c=='[':
                st.append(']')
            elif c=='(':
                st.append(')')
            elif c=='{':
                st.append('}')
            elif not st or c!=st.pop():
                return False
        return False if st else True
    
# Approach - 2

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack=[]
        closedToOpen={"}":"{","]":"[",")":"("}

        for c in s:
            if c in closedToOpen:
                if stack and stack[-1]==closedToOpen[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        return True if not stack else False
            