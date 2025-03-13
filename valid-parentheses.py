class Solution:
    def isValid(self, s: str) -> bool:
        # tc O(n), sc O(n).
        hashmap = {'{': '}', '[': ']', '(': ')'}
        stack = deque()

        for char in s:
            if char in hashmap:
                stack.append(char)
            else:
                if not stack:
                    return False
            
                if hashmap[stack[-1]] != char:
                    return False
                stack.pop()
        
        return not stack