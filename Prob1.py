class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        #time and space: O(n)
        stack = []
        bracket_map = {"(": ")", "[": "]",  "{": "}"}
        
        for ch in s:
            if ch in bracket_map:
                stack.append(bracket_map[ch])
            elif not stack or ch != stack.pop():
                return False
        
        if stack:
            return False
        
        return True
