# Time complexity - O(n)
#  Space complexity - O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        s1=[]
        for i in s:
            if i =='(':
                s1.append(')')
            elif i == '{':
                s1.append('}')
            elif i == '[':
                s1.append(']')
            elif(s1==[] or i != s1.pop()):
                return False
        if(s1 ==[]):
            return True
        else:
            return False
