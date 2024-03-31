"""
Time Complexity : O(n) where n is the length of the input string
Space Complexity : O(n) where n is the length of the input string, in worst case stack can have all the elements 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
If only one kind of parentheses are given then we can use the counter appraoch, we will have a counter variable and it will increment by 1 for the opening bracket and subtract 1 for the closing bracket, as soon as we find the counter value negative we will return False and at the end if we get counter value 0 return True

But the given problem states there are 3 types of parenthesis are present so we cannot use the above approach as it now it is also important to keep the order, hence we have to use some data structure to make sure we are keeping the order of the type of closing and opening of the same type of parenthesis.

Apprach:
If the input parenthesis is opening bracket, push the corresponding closing bracket to the stack and 
if the input parenthesis is closing bracket, pop the bracket at the top of the stack if they are same continue otherwise return False.
At the end return False if stack is not empty else True
"""


class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return True

        stack = []

        for char in s:
            if char == "(":
                stack.append(")")
            elif char == "[":
                stack.append("]")
            elif char == "{":
                stack.append("}")
            else:
                if len(stack) == 0:
                    return False
                if len(stack) > 0 and stack.pop() != char:
                    return False

        return False if len(stack) > 0 else True
