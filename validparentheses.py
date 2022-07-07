#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        chars = {'}':'{', ')':'(',']':'['}
        
        for char in s:
            if stack and char in chars:
                if stack.pop() != chars[char]:
                    return False
            else: 
                stack.append(char)
                
        if len(stack) == 0:
            return True
        else:
            return False