"""
Leetcode- https://leetcode.com/problems/valid-parentheses/
TC- O(N), SC- O(N)
Lecture-https://youtu.be/1GyQo-EiHgk
FAQ-
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false


Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
"""


class Solution:
    """
    *most optimized*
    Ideation-Stack O(N) TC
    The idea is that stack holds all opening braces and when you encounter a closing brace while iterating through the
    string, if the element that pops out of stack is not the compliment opener of that brace, the string is imbalanced.
    Another, when the string will be imbalanced is when at the end, stack has something in it but no closing bracket to
    balance it with. In none of the violations occur, we can consider the string is balance
    """

    def isValid(self, s: str) -> bool:
        stack = []
        hmap = {')': '(', ']': '[', '}': '{'}
        for c in s:
            if c in ['(', '[', '{']:
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                popEle = stack.pop()
                if popEle is not hmap[c]:
                    return False

        if len(stack) != 0:
            return False

        return True
