# -*- coding: utf-8 -*-
"""
TC:O(N) SC:O(N)
"""

"""
Algorithm used
We use a stack to store start time(t), length of intervals(iv) taken by other functions. 
Each level only talks to the adjacent levels. 
when a function is ended,we update the iv value corresponding to the outer function, if it exists.
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        T = [0]*n
        stack = []
        for x in logs:
            i, s, t = tuple(x.split(':'))
            i = int(i)
            t = int(t)
            if s == 'start':
                stack.append([t,0])
            if s == 'end':
                t0, iv = tuple(stack.pop()) 
                # "iv" represents the intervals that is occupied by sub-function on the level on the function starts at t.
                T[i] += 1 + t - t0 - iv
                if stack:
                    stack[-1][1] += 1 + t - t0
        return T
