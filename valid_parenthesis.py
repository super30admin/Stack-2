# -*- coding: utf-8 -*-
"""
TC: O(N) , N is the no. of elem in list
SC:Hashmap used O(K) where K is the diff types of brackets
"""

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        stack = []
        
        mapping = {")":"(","}":"{","]":"["}
        
        for i in s:
            
            if i in mapping and mapping[i] not in stack:
                return False
            
            if i not in mapping:
                stack.append(i)
            else:
                if mapping[i] in stack[-1]:
                    stack.pop(-1)
            
        if not stack:
            return True
        else:
            return False
