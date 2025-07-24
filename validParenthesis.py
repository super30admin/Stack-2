class Solution:
    def isValid(self, s: str) -> bool:
        par = {"(":")","[":"]","{":"}"}
        stack = []
        for i in range(len(s)):
            if s[i] in par:
                stack.append(s[i])
            else:
                if stack and par[stack[-1]] == s[i]:
                    stack.pop()
                else:
                    return False
        if not stack:
            return True
        return False