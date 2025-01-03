class Solution:
    def isValid(self, s: str) -> bool:
        
        stack = []
        pairs = {")": "(", "]":"[", "}":"{"}

        for c in s:
            if c in pairs:
                if not stack or stack.pop() != pairs[c]:
                    return False
            else:
                stack.append(c)
        
        if stack:
            return False
        return True





