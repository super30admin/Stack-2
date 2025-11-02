# Time is O(n)
# Space is O(n) as well for using the stack data structure

# The intuition here is to using Stack data structure for the LIFO strategy. Once we find a closed bracket, we check if the top of the stack was a open bracket, if not we immediately return False
# Then lastly after checking all the characters, if the stack still has some values then it means it did not have corresponding open bracket and still return False in that case.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(':
                stack.append(')')
            elif c == '{':
                stack.append('}')
            elif c == '[':
                stack.append(']')
            else:
                if not stack or c != stack.pop():
                    return False

        if stack: return False
        return True