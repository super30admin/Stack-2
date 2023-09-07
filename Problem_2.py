# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        pairs = {
            '(': ')',
            '{': '}',
            '[': ']' }
        for bracket in s:
            if bracket in pairs:
                stack.append(bracket)
            elif (len(stack) == 0) or (bracket != pairs[stack.pop()]):
                return False
        return len(stack) == 0