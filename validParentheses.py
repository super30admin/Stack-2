#O(n) time and O(1) solution
class Solution:
    def isValid(self, s: str) -> bool:
        openingBrackets = "([{"
        closingBrackets = ")]}"
        matchingBrackets = {")": "(", "]": "[", "}": "{"}
        stack = []
        for char in s:
            if char in openingBrackets:
                stack.append(char)
            elif char in closingBrackets:
                if len(stack) == 0:
                    return False
                if stack[-1] == matchingBrackets[char]:
                    stack.pop()
                else:
                    return False
        return len(stack) == 0
