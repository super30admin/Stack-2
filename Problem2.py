'''
1. Maintain two dictionaries, one for valid opening brackets and one for valid closing brackets
2. For each opening bracket, push it into the stack. For each closing bracket, pop the stack and check if the popped element is the corresponding opening bracket. If not, return False
3. If the stack is empty at the end, return True. Else, return False

Time Complexity: O(n)
Space Complexity: O(n) - Hashmap and stack
'''
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        valid = {'(':')', '{':'}', '[':']'}
        rev_valid = {')':'(', '}':'{', ']':'['}
        for c in s:
            if c in valid.keys():
                stack.append(c)
            else:
                if not stack or stack.pop()!=rev_valid[c]:
                    return False
        if stack:
            return False
        return True