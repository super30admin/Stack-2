''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
'''


class Solution:
    def isValid(self, s: str) -> bool:
        dictt = {')':'(', '}':'{', ']':'[' }
        stack = []
        for c in s:
            if c in dictt.keys():
                if stack and stack[-1] == dictt[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        
        return False if stack else True