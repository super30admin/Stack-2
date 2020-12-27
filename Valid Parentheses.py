# Time:- O(n)
# Space:- O(n)
# Approach:- If we see a closing bracket of any type we will check if the top of the stack is a opening 
# bracket of the same type, if not if it is a opening bracket we will push into the stack. In the end 
# we should have nothing in the stack if we found all matching braces.
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        my_stack=[]
        for i in s:
            if i==")" and len(my_stack)>0 and my_stack[-1]=='(':
                my_stack.pop()
            elif i=='}' and len(my_stack)>0 and my_stack[-1]=='{':
                my_stack.pop()
            elif i==']' and len(my_stack)>0 and my_stack[-1]=='[':
                my_stack.pop()
            elif i=='(' or i=='{' or i=='[':
                my_stack.append(i)
            else:
                return False
        if len(my_stack)==0:
            return True
        else:
            return False