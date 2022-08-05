# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def isValid(self, s):
        if len(s)%2 != 0:
            return False
        stack = []
        for i in s:
            if i == '(' or i == '{' or i == '[':
                stack.append(i)
            else:
                if stack:
                    if i == ')':
                        if stack.pop() != '(':
                            return False
                    elif i == ']':
                        if stack.pop() != '[':
                            return False
                    elif i == '}':
                        if stack.pop() != '{':
                            return False
                else:
                    return False
        if stack:
            return False

        return True
