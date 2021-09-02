#space:O(n)
#time:O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        dict_val = {"}":"{","]":"[",")":"("}
        stack = []
        for i in range(len(s)):
            if s[i] in dict_val and not stack:
                return False
            if s[i] not in dict_val:
                stack.append(s[i])
            if s[i] in dict_val:
                if stack:
                    if stack[-1]!=dict_val[s[i]]:
                        return False
                    else:
                        stack.pop()
        return False if stack else True