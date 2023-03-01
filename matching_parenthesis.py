# Time Complexity :
# O (N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through each character in the string. 
#If the character is an opening brace, we just push it into the stack. 
#If the character is a closing brace, we need to pop the top element of the stack and check if it is the opening brace corresponding to the current closing brace. If it is not, then we return False. If the stack is empty and we see a closing brace, we return False
#In the end, we check if the stack is empty - if it is we return True, False otherwise

class Solution:
    def isValid(self, s: str) -> bool:
        stack = collections.deque()
        opening_braces = ['(','[','{']
        closing_braces = [')',']','}']
        matching = {'[':']', '(':')', '{':'}'}

        for char in s :
            if char in opening_braces :
                stack.append(char)
                continue

            if char in closing_braces :
                if len(stack) == 0 :
                    return False
                last_char = stack.pop()
                if matching[last_char] != char:
                    return False

        return len(stack) == 0
