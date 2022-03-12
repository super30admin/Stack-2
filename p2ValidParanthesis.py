"""
time: O(N)
space: O(N)
"""


class Solution:
    def isValid(self, s: str) -> bool:
        #we will use stack
        #brackets are closed immediately
        dic = {'(': ')', '{': '}', '[':']'}
        stack =[]
        if len(stack) % 2 == 1:
            return False
        for i in s:
            if i in dic:
                stack.append(i)
            elif len(stack) == 0 or dic[stack.pop()] != i:
                return False
        return len(stack) == 0