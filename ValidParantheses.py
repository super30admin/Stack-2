--------------------------Valid parantheses------------------------------------------
# Time Complexity : O(N) as N is length of s 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# we wie through ll use stack and dict, we will have parentheses in dict and iterate through s and check if the char in dict
# or not, if it is open parentheses, we will append to the stack, else we will check if the top of the stack is same paranthesis or not
#If not we will return false else in the last we will check if there are any elements in the stack, return False
# else return True 


class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        
        d = {'(':')', '{':'}', '[':']'}
        stack = []
        for i in s:
            if i in d:
                stack.append(d[i])
            elif not stack or stack.pop() != i:
                return False
        return len(stack) == 0