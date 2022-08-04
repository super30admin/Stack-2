# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        if len(s) % 2 != 0:
            return False
        for i in s:
            if i == '(':
                stack.append(')')
            elif i == '{':
                stack.append('}')
            elif i == '[':
                stack.append(']')
            elif len(stack) == 0 or stack.pop() != i:
                return False
        return len(stack) == 0


print(Solution().isValid('{}[]()'))


# class Solution:
#     def isValid(self, s: str) -> bool:
#         stack = []
#         dictu = {'{':'}', '[':']', '(':')'}
#         dictu1 = {'}', ']', ')'}
#         for i in s:
#             if len(stack) == 0 and i in dictu1:
#                 return False
#             if i in dictu1:
#                 if dictu[stack[-1]] != i:
#                     return False
#                 stack.pop()
#             else:
#                 stack.append(i)
#         return len(stack) == 0
#
#
# print(Solution().isValid('{}[]()'))
