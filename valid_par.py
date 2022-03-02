# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []  # stack to keep track of opening brackets.

        for i in s:
            if i == '(':
                stack.append(i)

            elif i == '{':
                stack.append(i)

            elif i == '[':
                stack.append(i)

            else:

                if not stack:
                    return False

                top_element = stack.pop()

                if top_element == '(' and i == ')':
                    continue

                elif top_element == '{' and i == '}':
                    continue

                elif top_element == '[' and i == ']':
                    continue

                else:
                    return False

        if len(stack) > 0:
            return False

        else:
            return True
