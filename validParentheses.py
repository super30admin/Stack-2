# Time Complexity - O(N)
# Space Complexity - O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        if(s==None or len(s)==0):
            return True
        stack=[]
        for i in range(len(s)):
            c=s[i]
            if(c=='['):
                stack.append(']')
            elif(c=='{'):
                stack.append('}')
            elif(c=='('):
                stack.append(')')
            elif(not stack or stack.pop()!=c):
                return False
        if(stack):
            return False
        return True
        
