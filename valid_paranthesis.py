#Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 1:
            return False

        stack = []
        for char in s:
            if not stack and char in ']})':
                return False
            elif char == '(':
                stack.append(')')
            elif char == '[':
                stack.append(']')
            elif char == '{':
                stack.append('}')
            else:
                if stack and stack.pop() != char:
                    return False

        return  len(stack) == 0
        