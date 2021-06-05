class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        
        stack = []
        bracket = {'(':')','{':'}','[':']'}
        
#         for i in range(len(s)):
#             print(stack)
#             if s[i] == '(':
#                 stack.append(')')
#             elif s[i] == '{':
#                 stack.append('}')
#             elif s[i] == '[':
#                 stack.append(']')
#             elif not stack or s[i] != stack.pop():
#                 return False
#         if stack:
#             print("stack")
#             return False
        
#         return True
        
        for i in range(len(s)):
            if s[i] in bracket:
                stack.append(s[i])            
            elif not stack or bracket[stack.pop()] != s[i]:
                    return False            
        if stack:
            return False
        
        return True
                    
