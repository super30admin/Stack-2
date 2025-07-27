# S30 Problem #136 Valid Parentheses
#LeetCode #20 https://leetcode.com/problems/valid-parentheses/description/

# Author : Akaash Trivedi
# time complexity: O(n)
# space complexity O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# stack solution: append the closing parentheses to stack for every opening 
# if top of stack pop(), does not return the same then its invalid
# if single parenthes as "[[][]]" then we can use count, return false when count is negative but multiple should use stack
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for c in s:
            if c == "(":
                st.append(")")
            elif c == "{":
                st.append("}")
            elif c == "[":
                st.append("]")
            # the top of stack should match )}]
            elif not st or c != st.pop():
                return False
        return not st