class Solution:
    def isValid(self, s: str) -> bool:
        # empty string has no valid parentheses
        if s is None:
            return False

        # odd length string can't be balanced
        if len(s) % 2 != 0:
            return False

        # O(n) space
        stack = []

        # dictionary to map opening brackets to their corresponding closing ones
        bracket_map = {')': '(', '}': '{', ']': '['}

        # O(n) time
        for c in s:
            # if it's a closing bracket, check if it matches the top of the stack
            if c in bracket_map:
                if stack and stack[-1] == bracket_map[c]:
                    stack.pop()
                else:
                    return False
            else:
                # if it's an opening bracket, push it onto the stack
                stack.append(c)

        # output
        return not stack

