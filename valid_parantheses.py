# https://leetcode.com/problems/valid-parentheses/

# Time Complexity- O(n) Space Complexity- O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        # initialise the stack
        st = []

        # iterate through the given string
        for c in s:
            # if the char is in given defined string 
            if c in '({[':
                # append the stack
                st.append(c)
            # if the stack is empty
            elif not st:
                return False
            # check the matching close paranthesis
            elif c == ')' and st.pop() != '(':
                return False
            # check the matching close square bracket
            elif c == ']' and st.pop() != '[':
                return False
            # check the matching close curly bracket
            elif c == '}' and st.pop() != '{':
                return False
        # check if the stack is empty at the end, it returns true
        return not st