# check every incoming character in the string.
# if the character is an opening bracket, insert it's corresponding closing bracket in the stack.
# example - insert ")" in the stack for the incoming bracket "("
# if the character is a closing bracket, pop the top most element from the stack.
# compare it with the incoming character, if the two are equal, return False. 
# return True if the stack is empty.
# Time complexity - O(n)
# Space complexity - O(n) (worst case)
# did this code run on leetcode?- yes
# did you encounter any issues while coding this? - None

from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        
        for paran in s:
            if paran=="(":
                stack.append(")")
            elif paran=="[":
                stack.append("]")
            elif paran=="{":
                stack.append("}")
            else:
                if not stack:
                    return False
                top = stack.pop()
                if top != paran:
                    return False
    
        return not stack    # return True if s is empty
    
        