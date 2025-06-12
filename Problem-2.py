'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        n = len(s)

        for i in range(n):
            if s[i] in ('(', '{', '['):
                stack.append(s[i])
            elif len(stack):
                if s[i] == ")" and stack[-1] != "(":
                    return False
                if s[i] == "}" and stack[-1] != "{":
                    return False    
                if s[i] == "]" and stack[-1] != "[":
                    return False
                stack.pop()
            else:
                return False

        if len(stack):
            return False
            
        return True
        