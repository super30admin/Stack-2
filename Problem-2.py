    """
Approach: Stack
1) if open braces push to stack
2) if closed braces, pop and check the matching pair
3) if you are left with anymore closing chars and the stack is empty already, return False.
4) The stack needs to be empty at the end. 

TC: O(n) n-> len of string
SC: O(n)
"""
from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        hash_map = {'}' : '{', 
                    ']' : '[', 
                    ')' : '('}
        stack = deque()
        for char in s:
            if char in ('{','[','('): stack.append(char) 
            elif stack:
                curr = stack.pop()
                if hash_map[char] != curr: return False
            else: return False
        return not stack
                