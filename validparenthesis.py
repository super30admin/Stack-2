class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for character in s:
            if character == '(':
                stack.append(')')
            elif character == '{':
                stack.append('}')
            elif character == '[':
                stack.append(']')
            elif stack.__len__() == 0 or stack.pop() != character:
                return False

        return stack.__len__() == 0


