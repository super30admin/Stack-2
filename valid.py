# TC==>O(n)
# SC==>O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack, match = [], {')': '(', ']': '[', '}': '{'}
        for ch in s:
            if ch in match:
                if not (stack and stack.pop() == match[ch]):
                        return False
            else:
                stack.append(ch)
        return not stack