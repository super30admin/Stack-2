'''
Time Complexity: 0(n)
Space Complexity: 0(n) -- stack
Run on leetCode: Yes
'''
class Solution:
    def isValid(self, s: str) -> bool:
    
        # initialize a stack
        stack = []
        
        # iterate the string s
        for i in range(0,len(s)):
            # base-case
            if (s[i] == ')' or s[i] == ']' or s[i] == '}') and (len(stack) == 0):
                # close paranthesis with empty stack
                return False
            
            elif s[i] == '(' or s[i] == '{' or s[i] == '[':
                # push the open paranthesis to the stack
                stack.append(s[i])
            
            elif s[i] == ')' and stack[-1] == '(':
                # chk if peak of the stack is '(' paranthesis to maintain order
                # pop from the stack
                stack.pop()
            
            elif s[i] == '}' and stack[-1] == '{':
                # chk if peak of the stack is '{' paranthesis to maintain order
                # pop from the stack
                stack.pop()
            
            elif s[i] == ']' and stack[-1] == '[':
                # chk if peak of the stack is '[' paranthesis to maintain order
                # pop from the stack
                stack.pop()
            
            else:
                return False
        '''end of for loop'''
        
        if len(stack) == 0:
            return True
        else:
            return False
            
            