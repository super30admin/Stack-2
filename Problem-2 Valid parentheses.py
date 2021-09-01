class Solution:
    def isValid(self, s) :
        if s == None or len(s) == 0 or len(s) % 2 != 0:
            return False
        stack = []
        n = len(s)
        for i in range(n):
            c = s[i]
            if c == '(':
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            else:
                if not stack or c != stack.pop():
                    return False

        if len(stack) == 0:
            return True
        else:
            return False