#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct  8 10:23:09 2019

@author: tanvirkaur
Time Complexity = O(logs)
Space Complexity = O(n)
"""


class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        res = [0]*n
        stack = []
        prev = 0
        for log in logs:
            first ,second,third  = log.split(':')
            first = int(first)
            third = int(third)
            curr = third
            if second == 'start':
                if stack:
                    res[stack[-1]] += curr - prev
                stack.append(first)
                prev = curr
            else:
                res[stack.pop()] += curr-prev + 1
                prev = curr + 1
        return res