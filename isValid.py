# Time Complexity: O(n)
# Space Complexity: O(1)
# Approach: Iterate the string. Whenever an open bracket is found, push it in the stack.
#			When a close bracket is found check if the stack top has the appropriate open bracket if so pop stack and continue to next bracket.
#			If not return False
#			After the loop processes, and if the stack length is 0 then all brackets have matched and return True else return False. 
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        open_brackets = ("(", "{", "[")
        close_brackets = (")", "}", "]")
        
        for i in s:
            if i in open_brackets:
                stack.append(i)
            else:
                idx = close_brackets.index(i)
                if len(stack) > 0 and stack[-1] == open_brackets[idx]:
                    stack.pop()
                else:
                    return False
        
        if len(stack) != 0:
            return False
        
        return True