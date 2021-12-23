#20 : valid parenthesis
# time - O(n)
# space - O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        
        stack = []
        hashmap = {'(':')', '{':'}', '[':']', '*':'*'}
        s = "*" + s + "*"
        for char in s:
            
            if char in ["[", "(", "{"]:
                stack.append(char)
                
            elif char in ["]", ")", "}"]:
                if len(stack) == 0:
                    return False
                if hashmap[stack[-1]] == char:
                    stack.pop()
                else:
                    return False
        
        return len(stack) == 0