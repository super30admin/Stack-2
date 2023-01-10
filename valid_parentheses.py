class Solution:
    def isValid(self, s: str) -> bool:
        ## T.C = O(n)
        ## S.C = O(n)

        stack = []

        for i in range(len(s)):
            if s[i] == '{':
                stack.append('}')
            elif s[i] == '[':
                stack.append(']')
            elif s[i] == '(':
                stack.append(')')
            elif not stack or stack[-1] != s[i]:
                return False
            else:
                stack.pop()
        
        return stack == []
