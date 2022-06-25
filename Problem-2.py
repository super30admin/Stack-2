class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        pairs={'(':')', '[':']','{':'}'}
        
        for char in s:
            if char in pairs.keys():
                stack.append(char)
                
            elif char in pairs.values():
                if (len(stack)==0 or char!=pairs[stack.pop()]):
                    return False
            else:
                return False
          
        return stack==[]
        