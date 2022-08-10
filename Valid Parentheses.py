# TC: O(N)
# SC: O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapbrackets = { ")" :"(", "}":"{", "]":"["}
        
        for char in s:
            if char in mapbrackets:
                if stack and stack[-1] == mapbrackets[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        return not stack