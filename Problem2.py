#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i == '(':
                stack.append(')')
            elif i == '[':
                stack.append(']')
            elif i == '{':
                stack.append('}')
            elif not stack or stack.pop() != i:
                return False

        if not stack:
            return True
        else:
            return False
                
                