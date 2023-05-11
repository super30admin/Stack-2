# TC - O(n)
# SC - O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        n = len(s)
        if n%2 != 0: 
            return False 
        if n == 0:
            return True 

        stack = []

        for i in range(n):
            if s[i] == "(":
                stack.append(")")
            elif s[i] == "{":
                stack.append("}")
            elif s[i] == "[":
                stack.append("]")
            else:
                if not stack or s[i] != stack.pop():
                    return False
        return len(stack) == 0
