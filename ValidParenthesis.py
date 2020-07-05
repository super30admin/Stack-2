'''
Solution:
1.  This is a standard question where we use a stack to solve the validity of the expression.
2.  When an open bracket is seen => push and when corresponding closed bracket is seen => pop
3.  If anything is remaining in the stack or corresponding closed bracket not seen => return False

Time Complexity:    O(N)    |   Space Complexity:   O(N)

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def isValid(self, s: str) -> bool:
        
        #   initializations
        openCloseMap = { ')': '(', '}': '{', ']': '['}
        openSet = set(['(', '{', '['])
        stack = []
        
        #   iterate each bracket
        for char in s:

            #   open bracket
            if char in openSet:
                stack.append(char)

            #   closed bracket
            elif char in openCloseMap:
                if (len(stack) <= 0 or openCloseMap[char] != stack[-1] ):
                    return False
                stack.pop()
        
        #   return whether stack is empty or not       
        return (len(stack) == 0)                   
                