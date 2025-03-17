#Time: O(n)
#space: O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) <=1:
            return False
        
        stack=[]
        for i in range(len(s)):
            if len(stack) == 0:
                stack.append(s[i])

            else:
                top_element=stack[-1]
                if (top_element == '(' and s[i] ==')') or (top_element == '{' and s[i] =='}') or (top_element == '[' and s[i] ==']'):
                    stack.pop()
                    continue
                stack.append(s[i])
        if len(stack) == 0:
            return True
        return False

