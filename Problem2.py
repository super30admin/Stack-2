## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

class Solution:
    def isValid(self, s: str) -> bool:
        if s==None or len(s)==0:
            return False
        stack = []
        for i in range(len(s)):
            c = s[i]
            if c =='(':
                stack.append(')')
            elif c =='{':
                stack.append('}')
            elif c == '[':
                stack.append(']')
            elif len(stack)==0 or c!=stack.pop():
                return False
        if len(stack)!=0:
            return False
        return True
    
#Time Complexity: O(n) n = len(s)
#Space Complexity: O(n)
#Approach: Using stack. Push a reverse counter symbol when ever we 
# encounter a opening bracket. If a closing bracket is encountered pop 
# and check if the order in the stack and string are similar and return 
# True or False accordingly. 
