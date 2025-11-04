# Time Complexity : O(N) as we are iterating through the tokens list once
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a stack to keep track of the opening parentheses.
# I will iterate through each character in the input string.
# If the character is an opening parentheses, I will push it onto the stack.
# If the character is a closing parentheses, I will check if the stack is empty or if the top of the stack does not match the corresponding opening parentheses.
# If either condition is true, I will return False.
# At the end of the iteration, if the stack is empty, I will return True, indicating that the parentheses are valid.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hashmap = {"(":")","{":"}","[":"]"}
        for i in s:
            if i in hashmap:
                stack.append(i)
            elif len(stack)== 0 or i != hashmap[stack.pop()]:
                return False
        return len(stack) == 0
            
        