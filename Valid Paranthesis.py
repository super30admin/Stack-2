#// Time Complexity : O(N) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def isValid(self, s: str) -> bool:
        stack =[]
        if len(s) <= 1:
            return False
        for i in range(len(s)):
            if s[i] == '(' or s[i] == '{' or s[i] == "[":
                stack.append(s[i])
            else:
                if stack:
                    abc = stack.pop()
                else: 
                    return False
                if (s[i] == ")" and abc == "(" ) or (s[i] == "}" and abc == "{") or (s[i] == "]" and abc == "["):
                    continue 
                else:
                    return False
        if stack:
            return False
        return True

# Approach:
# 1. Initialize an empty stack.
# 2. Iterate over the string. If the character is an opening bracket, push it to the stack
# 3. If the character is a closing bracket, check if the stack is empty. If it is
# 4. If the stack is not empty, pop the opening bracket from the stack and check if it
# 5. If the stack is empty after iterating over the string, return False. If the stack is
# 6. Return True if the stack is empty, False otherwise.
