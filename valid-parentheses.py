'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return False
        
        stack = list()
        
        for c in s:
            if c == "(":
                stack.append(")")
            elif c == "{":
                stack.append("}")
            elif c == "[":
                stack.append("]")
            else:
                if not stack or stack[-1] != c:
                    return False
                stack.pop()
        
        return True if not stack else False
        