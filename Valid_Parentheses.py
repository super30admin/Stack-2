# Time Complexity : O(n), where n is the length of the string s
# Space Complexity : O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        brackets = {')': '(', ']': '[', '}': '{'}

        for char in s:
            if char in brackets.values():
                stack.append(char)
            elif char in brackets.keys():
                if not stack or stack.pop() != brackets[char]:
                    return False
            else:
                return False

        return len(stack) == 0
