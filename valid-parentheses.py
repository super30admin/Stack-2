# O(n) time, O(n) space
class Solution:
    def isValid(self, s: str) -> bool:

        closeToOpen = {')':'(',']':'[','}':'{'}
        stack=[]
        for c in s:
            if c in closeToOpen:
                if stack and stack[-1]==closeToOpen[c]:
                    stack.pop()
                else:
                    return False 
            else:
                stack.append(c)


        if stack:
            return False
        else:
            return True