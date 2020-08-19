# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a stack containing active open brackets
2. As sson as closing bracket is encountered check if its corresponding open is present at peek, if not return false
3. Finally the stack should be empty if yes return true else return false

'''

from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        
        if not s or len(s) < 1:
            return True
        
        
        parenthesis_dict = {')':'(', '}':'{', ']':'['}
        
        stack = deque()
        for ch in s:
            if ch in parenthesis_dict.values():
                stack.append(ch)
            
            else:
                if stack and parenthesis_dict[ch] == stack.pop():
                    continue
                else:
                    return False
    
        return len(stack) <= 0
                