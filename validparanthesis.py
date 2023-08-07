# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :No
class Solution:
    def isValid(self, s: str) -> bool:
        d = {'(':')', '{':'}','[':']'}
        stack = []
        for i in s:
            if i in d:  #
                stack.append(i)
            elif len(stack) == 0 or d[stack.pop()] != i:  
                return False
        return len(stack) == 0 

        

            