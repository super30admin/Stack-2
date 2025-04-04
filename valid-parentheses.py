# Time O(n)
# Space O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c in ('[', '(','{'):
                stack.append(c)
            else:
                if len(stack) == 0: return False
                opening = stack.pop()
                if (c == ')' and opening != '(') or  (c == '}' and opening != '{') or (c == ']' and opening != '['):
                    return False
        if len(stack) > 0: return False
        return True
