# Time-Complexity: O(n)
# Space Complexity: O(n)
# Leetcode status: Accepted
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == None or len(s) == 0:
            return True
        if len(s)%2 !=0:
            return False
        stk = []

        for bracket in s:
            if bracket == "(":
                stk.append(")")
            elif bracket == "[":
                stk.append("]")
            elif bracket == "{":
                stk.append("}")
            elif len(stk)!=0 and bracket == stk[-1]:
                stk.pop()
            else:
                return False
        if len(stk) == 0:
            return True
        return False
                
        
