#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closetoopen = {')':'(','}':'{',']':'['}
        for c in s:
            if c in closetoopen:
                if(len(stack)>0 and stack[-1]==closetoopen[c]):
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        return True if(len(stack)==0) else False
