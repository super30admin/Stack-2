# // Time Complexity : O(N)
# // Space Complexity : O(N)




class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s==None or len(s)==0: return False
        stack=[]
        for i in range(len(s)):
            if s[i]=='(':
                stack.append(')')
            elif s[i]=='{':
                stack.append('}')
            elif s[i]=='[':
                stack.append(']')
            else:
                if (stack==[] or s[i] != stack.pop()): return False
            

        return stack==[]

# class Solution(object):
#     def isValid(self, s):
#         """
#         :type s: str
#         :rtype: bool
#         """
#         if s==None or len(s)==0: return False
#         stack=[]
#         for i in range(len(s)):
#             if s[i]=='(':
#                 stack.append(')')
#             if s[i]=='{':
#                 stack.append('}')
#             if s[i]=='[':
#                 stack.append(']')
#             if s[i]==')':
#                 if stack!=[] and stack.pop()==')':
#                     continue
#                 else:
#                     return False
#             if s[i]=='}':
#                 if stack!=[] and stack.pop()=='}':
#                     continue
#                 else:
#                     return False
#             if s[i]==']':
#                 if stack!=[] and stack.pop()==']':
#                     continue
#                 else:
#                     return False
#         if len(stack)==0: return True
                
            