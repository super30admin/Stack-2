from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        for i in s:
            if i == '(':
                stack.append(')')
            elif i == '{':
                stack.append('}')
            elif i == '[':
                stack.append(']')
            elif not stack or stack[-1]!=i:
                return False
            elif i == stack[-1]:
                stack.pop()
        return True if not stack else False


#time complexity - O(n)

#space complexity - O(n)

#all test cases passed