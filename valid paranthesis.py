# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def isValid(self, st):

        stack = []

        # hash map to keep track of the type of parenthesis
        b_map = {'(': ')', '[': ']', '{': '}'}
        open_c = ('(', '[', '{')  # set to identify open brackets

        for i in st:

            # append to stack if open brackets
            if i in open_c:
                stack.append(i)

            # if the type matches the top element, pop
            elif stack and i == b_map[stack[-1]]:
                stack.pop()
            else:
                return False

        return stack == []