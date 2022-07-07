#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        lst=[]
        for i in s:
            if i in ['{','(','[']:
                lst.append(i)
            elif lst and self.reverse(i)==lst[-1]:
                lst.pop()
            else:
                return False
        if lst==[]:
            return True
        
    def reverse(self,bracket):
        if bracket==')':
            return '('
        elif bracket=='}':
            return '{'
        else:
            return '['