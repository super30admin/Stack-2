# TC O(n)
# SC O(n) to maintain the stack
# Code ran on LeetCode
# Iterate over the string and add opening brackets to the stack. When a clocing bracket is reached, check if the corresponding opening bracket is in the top of the stack and pop that element from the stack.
class Solution:
    def isValid(self, s: str) -> bool:

        stack = []

        for i in range(len(s)):
            if s[i] in ['(', '{', '[']:
                stack.append(s[i])
            elif stack != []:
                popped = stack.pop()

                if (popped == '(' and s[i] == ')') or (popped == '{' and s[i] == '}') or popped == '[' and s[i] == ']':
                    continue
                else:
                    return False
            else:
                return False
        return stack == []
