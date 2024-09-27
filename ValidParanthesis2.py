#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct  8 10:25:44 2019

@author: tanvirkaur
"""

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dic = {']' : '[', '}' : '{', ')' : '('}
        stack = []
        for char in s:
            if char in dic.viewvalues():
                stack.append(char)
            elif char in dic:
                if not stack or stack.pop() != dic[char]:
                    return False
        if not stack:
            return True
        else:
            return False
                