class Solution:
    def isValid(self, s: str) -> bool:
        pairs = { "(":")", "{":"}", "[":"]"}
        stack = []
        
        for i in s:
            if i in pairs:
                stack.append(i)
            elif stack:
                if pairs[stack[-1]] != i:
                    return False
                else:
                    stack.pop()
            else:
                return False
        return not stack
Time: O(n)
SPace: O(n)
