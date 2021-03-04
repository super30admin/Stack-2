# Created by Aashish Adhikari at 5:47 PM 3/2/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(n)
'''

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0:
            return True

        from collections import deque
        stack = deque()

        for idx in range(len(s)):

            char = s[idx]

            if char == "(" or char == "[" or char == "{":

                stack.append(str(char))
            else:

                if len(stack) == 0:
                    return False
                else:
                    stack_top = stack.pop()

                    if stack_top == "(" and char ==")":
                        pass
                    elif stack_top == "[" and char =="]":
                        pass
                    elif stack_top == "{" and char =="}":
                        pass
                    else:
                        return False


        if len(stack) == 0:
            return True

        return False