'''

## Problem 20: Valid Parentheses

## Author: Neha Doiphode
## Date:   09-28-2022

## Description:
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

# Examples
    Example 1:
        Input: s = "()"
        Output: true

    Example 2:
        Input: s = "()[]{}"
        Output: true

    Example 3:
        Input: s = "(]"
        Output: false

## Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

## Time complexity: O(n), where n is the length of the bracket string as we need to traverse the whole string to reach a conclusion on the validness.

## Space complexity: O(n), where n is the length of the bracket string, in worst case we will have all characters in the string pushed onto the stack
                           (if the string contains all opening brackets or any one type of brackets.)

'''

from typing import List, Optional

def get_input():
    print("Enter the bracket string: ", end = "")
    try:
        string = input()
    except KeybordInterrupt:
        pass
    return string

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        valid = True
        look_up = dict()
        look_up[')'] = '('
        look_up[']'] = '['
        look_up['}'] = '{'

        for char in s:
            if char in look_up.values():
                stack.append(char)
            elif stack:
                opening = stack.pop()
                if char in look_up and look_up[char] != opening:
                    valid = False
                    break
            else:
                valid = False
                break

        if len(stack) == 0 and valid == True:
            return True

        return False


# Driver code
solution = Solution()
string = get_input()
print()
print(f"Input: Bracket string: {string}")
print(f"Output: Is input bracket string valid?: {solution.isValid(string)}", end = "")
print()
