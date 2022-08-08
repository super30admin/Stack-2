# Approach: Use stack to maintain open brackets/parathesis etc and as you encounter closing counterparts, 
# validate those against the stack top to ensure its valid. If not, return False.
# TC: O(N)
# SC: O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closeToOpen = {
            ")" :"(", "}":"{", "]":"["
        }
        
        for char in s:
            if char in closeToOpen:
                if stack and stack[-1] == closeToOpen[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        return not stack