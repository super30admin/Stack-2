class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)%2 != 0:
            return False
        stack = []
        h = {"(":")","{":"}","[":"]"}
        # l = ["(","{","["]
        for i in s:
            if i in h.keys():
                stack.append(i)
            elif stack and i == h[stack[-1]]:
                stack.pop()
            else:
                return False
        return stack == []