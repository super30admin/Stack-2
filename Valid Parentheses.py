# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def isValid(self, s: str) -> bool:
        if(len(s) == 0 or len(s)%2 == 1):
            return False
        stack = list()
        for i in s:
            if(i == '('):
                stack.append(')')
            elif(i == '{'):
                stack.append('}')
            elif(i == '['):
                stack.append(']')
            elif(len(stack) == 0 or i != stack.pop()):
                return False
            # elif(len(stack) > 0):
            #     if(i == stack[-1]):
            #         stack.pop()
            #     else:
            #         return False
            # else:
            #     return False      
        return True if(len(stack) == 0) else False
                    
        
#         d = {'(':True, '{':True,'[':True}
        
#         if(len(s)<2 or len(s)%2!=0):
#             return False
        
#         l = list()
        
#         for i in s:
#             if(i in d):
#                 l.append(i)
#             else:
#                 if(len(l) > 0 and i==')' and l[-1]=='('):
#                     l.pop()
#                 elif(len(l) > 0 and i=='}' and l[-1]=='{'):
#                     l.pop()
#                 elif(len(l) > 0 and i==']' and l[-1]=='['):
#                     l.pop()    
#                 else:
#                     return False
#         if(len(l)==0):
#             return True
#         else:
#             return False
        
        
