"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def isValid(self, s: str) -> bool:
        """
        Algo
        - If the string is empty - return true
        - Initialize stk = []
        - open_chars, close_chars
        - Iterating over the chracters in string
            - if stk is not empty and stk[-1] == open and current is closed
                - pop stk
            - add the char to stk
        - if stk empty - true
        - else false
        
        """
        if not s:
            return True
        stk = []
        open_close_map = {'(':')','{':'}','[':']'}
        for c in s:
            if stk and stk[-1] in open_close_map and c in open_close_map[stk[-1]]:
                stk.pop()
            else:
                stk.append(c)
        if stk:
            return False
        return True